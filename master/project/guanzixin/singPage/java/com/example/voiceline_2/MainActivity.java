package com.example.voiceline_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.carlos.voiceline.mylibrary.VoiceLineView;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnRecord;
    private Button btnStop;
    private Button btnMic;
    private RelativeLayout relativeMic;
    private Button btnRe;

    //记录当前录音状态（默认为false）
    private boolean isRecord = false;
    //创建AudioRecord对象
    private AudioRecord audioRecord;
    //音频采集来源
    private static final int mAudioSource = MediaRecorder.AudioSource.MIC;
    //音频采样率 (MediaRecoder的采样率通常是8000Hz AAC的通常是44100Hz.设置采样率为44100目前为常用的采样率，官方文档表示这个值可以兼容所有的设置）
    private static final int mSampleRateInHz = 44100;
    //声道
    private static final int mChannelConfig = AudioFormat.CHANNEL_IN_MONO;
    //数据格式  (指定采样的数据的格式和每次采样的大小)
    //指定音频量化位数 ,在AudioFormaat类中指定了以下各种可能的常量。通常我们选择ENCODING_PCM_16BIT和ENCODING_PCM_8BIT PCM代表的是脉冲编码调制，它实际上是原始音频样本。
    //因此可以设置每个样本的分辨率为16位或者8位，16位将占用更多的空间和处理能力,表示的音频也更加接近真实。
    private static final int mAudioFormat = AudioFormat.ENCODING_PCM_16BIT;
    //指定最小录音缓冲区大小
    private int mBufferSizeInBytes = 0;
    //将pcm数据写入文件的流
    private DataOutputStream out;

    //声波图形部分
    private VoiceLineView voiceLineView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    if(audioRecord==null) return;
                    //分贝
                    double db = (double) msg.obj;
                    //默认的最大音量是100,可以修改，但其实默认的，在测试过程中就有不错的表现
                    //你可以传自定义的数字进去，但需要在一定的范围内，比如0-200，就需要在xml文件中配置maxVolume
                    //同时，也可以配置灵敏度sensibility
                    //只要有一个线程，不断调用这个方法，就可以使波形变化
                    //主要，这个方法必须在ui线程中调用
                    voiceLineView.setVolume((int) (db));
                    Log.i("gzx","声贝值：" + (int)db);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取视图控件
        findViews();
        //设置监听
        setListeners();
    }

    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_record:
                    //判断录音状态
                    if(isRecord){//如果正处于录音状态，则暂停录音
                        //改变录音状态
                        isRecord = false;
                        //改变麦克风图片
                        btnMic.setBackgroundResource(R.drawable.mic);
                        relativeMic.setBackgroundResource(R.drawable.micback);
                        Log.i("gzx","设备暂停录音");
                        pauseRecord();
                    }else{//不处于录音状态
                        //改变录音状态
                        isRecord = true;
                        //改变麦克风图片
                        btnMic.setBackgroundResource(R.drawable.mic0);
                        relativeMic.setBackgroundResource(R.drawable.micback0);
                        //开始录音
                        startRecord();
                        Log.i("gzx","设备处于录音状态");
                    }
                    break;
                case R.id.btn_record_stop:
                    if(isRecord){//设备正处于录音状态
                        //更改录音状态
                        isRecord = false;
                        //改变麦克风图片
                        btnMic.setBackgroundResource(R.drawable.mic);
                        relativeMic.setBackgroundResource(R.drawable.micback);
                        Log.i("gzx","设备结束录音");
                        //先暂停录音
                        pauseRecord();
                    }else{
                        //设备不处于录音状态，不做特殊处理
                    }
                    //拼接整合所有中途录音文件
                    StopRecord();
                    break;
                case R.id.btn_record_re:
                    if(isRecord){//设备正处于录音状态
                        //更改录音状态
                        isRecord = false;
                        //改变麦克风图片
                        btnMic.setBackgroundResource(R.drawable.mic);
                        relativeMic.setBackgroundResource(R.drawable.micback);
                        Log.i("gzx","设备结束录音");
                        //先暂停录音
                        pauseRecord();
                    }else{
                        //设备不处于录音状态，不做特殊处理
                    }
                    //清空recording中缓存文件
                    new Thread(){
                        @Override
                        public void run() {
                            //获取文件夹下所有文件
                            File dir = new File(Environment.getExternalStorageDirectory().getPath() + "/rapStar" + "/recording");
                            final File[] files = dir.listFiles();//recording文件目录下所有文件放入数组中
                            if(null != files){
                                //文件夹不为空，删除recording目录中的所有暂存文件(files目录中所有文件)
                                for(File file : files){
                                    file.delete();
                                }
                            }
                        }
                    }.start();
                    break;
            }
        }
    }

    /**
     * 拼接整合所有录音文件
     */
    private void StopRecord() {
        //用于存储文件名称
        final List<String> audioList = new ArrayList<>();
        //获取文件夹下所有文件
        File dir = new File(Environment.getExternalStorageDirectory().getPath() + "/rapStar" + "/recording");
        final File[] files = dir.listFiles();//recording文件目录下所有文件放入数组中
        if(null != files){
            //文件夹不为空，获取列表中所有文件名
            for(int i = 0;i < files.length;i++){
                String fileName = files[i].getName();
                audioList.add(fileName);
            }
        }
        Log.i("gzx","所有录音文件名：" + audioList.toString());
        //拼接录音文件
        new Thread(){
            @Override
            public void run() {
                for(String audioName : audioList){
                    try{
                        //拼接
                        joinAudio(audioName,audioList.get(0));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                //删除recording目录中的所有暂存文件(files目录中所有文件)
                if(null != files){
                    for(File file : files){
                        file.delete();
                    }
                }
                //将pcm文件转换成wav文件
                //设置音频名称
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
                Date date = new Date(System.currentTimeMillis());
                String recordName = formatter.format(date) + ".wav";
                try {
                    pcmTowav(Environment.getExternalStorageDirectory().getPath() + "/rapStar" + "/records/" + audioList.get(0),Environment.getExternalStorageDirectory().getPath() + "/rapStar" + "/records/" + recordName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 音频的拼接方法
     * @param audioName 当前文件名称
     * @param s 输出文件名称（录音列表的第一个名字）
     */
    private void joinAudio(String audioName, String s) {
        //录音暂存文件路径
        String recordPath = Environment.getExternalStorageDirectory().getPath() + "/rapStar" + "/recording/";
        File audioFile = new File(recordPath + audioName);
        //录音最终存储文件路径
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/rapStar" + "/records");
        if( !(file.exists()) ){
            //如果文件夹不存在
            file.mkdirs();//创建文件夹
        }
        String storagePath = Environment.getExternalStorageDirectory().getPath() + "/rapStar" + "/records/";
        File toFile = new File(storagePath + s);
        //拼接音频
        try {
            FileInputStream in = new FileInputStream(audioFile);
            FileOutputStream out = new FileOutputStream(toFile,true);
            byte bs[]=new byte[1024*4];
            int len=0;
            //先读第一个
            while((len=in.read(bs))!=-1){
                out.write(bs,0,len);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pcmTowav(String pcmfilepath , String wavfilepath ) throws IOException {
        FileInputStream pcmIn;
        FileOutputStream wavOut;
        System.out.print("pcmfilepath" + pcmfilepath);
        System.out.print("wavfilepath" + wavfilepath);
        //原始pcm数据大小不含(文件头),添加文件头要用
        long pcmLength;
        //文件总大小(含文件头),添加文件头要用
        long dataLength;
        //通道标识（1(单通道)或2(双通道)，添加文件头要用）
        int channels = (mChannelConfig == AudioFormat.CHANNEL_OUT_MONO ? 1 : 2);
        //采样率，添加文件头要用
        int sampleRate = mSampleRateInHz;
        //信息传输速率=((采样率*通道数*每样值位数) / 8),添加文件头要用
        int byteRate = sampleRate*channels*16/8;
        byte[] data = new byte[mBufferSizeInBytes];
        pcmIn = new FileInputStream(pcmfilepath);
        wavOut = new FileOutputStream(wavfilepath);
        pcmLength = pcmIn.getChannel().size();
        //wav文件头44字节
        dataLength = pcmLength+44;
        //先写入wav文件头
        writeHeader(wavOut , pcmLength , dataLength , sampleRate , channels , byteRate);
        //再写入数据
        while (pcmIn.read(data)!=-1){
            wavOut.write(data);
        }
        Log.i("TAG","wav文件写入完成");
        pcmIn.close();
        wavOut.close();
    }

    private void writeHeader(FileOutputStream wavOut, long pcmLength, long dataLength, int sampleRate, int channels, int byteRate) throws IOException {
        //wave文件头44个字节
        byte[] header = new byte[44];
        /*0-11字节(RIFF chunk ：riff文件描述块)*/
        //文件标记为RIFF文件
        header[0]='R';
        header[1]='I';
        header[2]='F';
        header[3]='F';
        //文件总长度
        header[4]= (byte) (dataLength * 0xff); //取一个字节（低8位）
        header[5]= (byte) ((dataLength >> 8) * 0xff); //取一个字节 （中8位）
        header[6]= (byte) ((dataLength >> 16) * 0xff); //取一个字节 (次8位)
        header[7]= (byte) ((dataLength >> 24) * 0xff); //取一个字节 （高8位）
        //文件类型标记为WAVE
        header[8]='W';
        header[9]='A';
        header[10]='V';
        header[11]='E';
        /*13-35字节(fmt chunk : 数据格式信息块)*/
        //标记格式块,描述数据格式信息 4个字节
        header[12]='f';
        header[13]='m';
        header[14]='t';
        header[15]=' '; //要有一个空格
        //格式数据的长度 4个字节
        header[16]=16;
        header[17]=0;
        header[18]=0;
        header[19]=0;
        //格式类型（如1 是 PCM） 2个字节
        header[20]=1;
        header[21]=0;
        //通道数 1为单声道，2为双声道
        header[22]= (byte) channels;
        header[23]=0;
        //采样率
        header[24]= (byte) (sampleRate * 0xff);
        header[25]= (byte) ((sampleRate >> 8) * 0xff);
        header[26]= (byte) ((sampleRate >> 16) * 0xff);
        header[27]= (byte) ((sampleRate >> 24) * 0xff);
        //比特率=(采样率* 每样值位数*渠道) / 8。
        header[28] = (byte) (byteRate & 0xff);
        header[29] = (byte) ((byteRate >> 8) & 0xff);
        header[30] = (byte) ((byteRate >> 16) & 0xff);
        header[31] = (byte) ((byteRate >> 24) & 0xff);
        // (每样值位数* 通道)/8  所有通道的一个样值所需比特数  其中的声道数至少为2，小于2的按2算
        header[32]= (16 * 2 / 8); //（比如PCM16，双声道的1个Frame等于16*2/8=4字节），
        header[33]= 0 ;
        //每样值位数（常用16比特或8比特表示样值）
        header[34]=16;
        header[35]=0;
        /*36字节之后 (data chunk : 数据块)*/
        //"data"块标记，标记数据节开始。
        header[36]='d';
        header[37]='a';
        header[38]='t';
        header[39]='a';
        //描述数据节的大小
        header[40] = (byte) (pcmLength & 0xff);
        header[41] = (byte) ((pcmLength >> 8) & 0xff);
        header[42] = (byte) ((pcmLength >> 16) & 0xff);
        header[43] = (byte) ((pcmLength >> 24) & 0xff);
        //写入文件头
        wavOut.write(header,0,44);
    }

    private void pauseRecord() {
        try {
            //关闭录音并释放相关资源
            out.close();
            audioRecord.stop();
            audioRecord.release();
            audioRecord = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 使用audioRecorder录音
     */
    private void startRecord() {
        //计算最小录音缓冲区大
        mBufferSizeInBytes = AudioRecord.getMinBufferSize(mSampleRateInHz,mChannelConfig,mAudioFormat);
        //创建AudioRecord对象
        audioRecord = new AudioRecord(mAudioSource,mSampleRateInHz,mChannelConfig,mAudioFormat,mBufferSizeInBytes);
        //设置音频输入路径及音频名称
        //设置音频名称
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date(System.currentTimeMillis());
        String fileName = formatter.format(date) + ".pcm";
        //设置音频输入路径
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/rapStar" + "/recording");
        if( !(file.exists()) ){
            //如果文件夹不存在
            file.mkdirs();//创建文件夹
        }
        String path = Environment.getExternalStorageDirectory().getPath() + "/rapStar" + "/recording";
        //创建pcm数据存储的文件
        final File pcmFile = new File(path + "/" + fileName);
        if(pcmFile.exists()){
            //如果文件已存在，则删除重新创建
            pcmFile.delete();
        }

        new Thread(){
            @Override
            public void run() {
                try {
                    //创建pcm文件
                    pcmFile.createNewFile();
                    out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pcmFile)));
                    byte[] buffer = new byte[mBufferSizeInBytes];
                    //开始录音
                    audioRecord.startRecording();
                    Log.i("gzx","开始录音");
                    while(isRecord == true){
                        int bufferReadResult = audioRecord.read(buffer,0,mBufferSizeInBytes);
                        //如果音频数据没有错误,就写入文件
                        long v = 0;
                        if (AudioRecord.ERROR_INVALID_OPERATION != bufferReadResult && out != null){
                            for (int i=0 ; i < bufferReadResult ; i++){
                                out.write(buffer[i]);
                                if(buffer[i] > v){
                                    v += buffer[i] * buffer[i];
                                }
                            }
                        }
                        //声波部分(平方和除以数据总长度，得到音量大小)
                        double mean = v / (double) bufferReadResult;
                        //分贝值
                        double volume = 100 * Math.log10(mean);
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = volume;
                        handler.sendMessage(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    private void setListeners() {
        MyListener myListener = new MyListener();
        btnRecord.setOnClickListener(myListener);
        btnStop.setOnClickListener(myListener);
        btnRe.setOnClickListener(myListener);
    }

    private void findViews() {
        btnRecord = findViewById(R.id.btn_record);
        btnStop = findViewById(R.id.btn_record_stop);
        btnMic = findViewById(R.id.btn_record_mic);
        relativeMic = findViewById(R.id.relative_mic);
        btnRe = findViewById(R.id.btn_record_re);
        voiceLineView = findViewById(R.id.voicLine);
    }
}
