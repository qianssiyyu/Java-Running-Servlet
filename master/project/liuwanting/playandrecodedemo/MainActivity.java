package com.example.playandrecodedemo;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button btnBegin;
    private File decodeFile = null; // 解码文件夹
    private String decodePath;
    private String path;
    private Handler myHandler;
    private String rawAudioFile;
    //定义录制音频的MediaRecorder属性
    private MediaRecorder recorder;
    private MediaPlayer mediaPlayer;
    //定义AssetManager属性
    private AssetManager assetManager;
    //定义标识当前音频的id属性
    private int cur = 1;
    private Button btnStop;
    private String name = "lwt";
    private String onepath;
    private String twopath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBegin = findViewById(R.id.btn_begin);
        btnStop = findViewById(R.id.btn_stop);
        decodePath = this.getFilesDir().getAbsolutePath()+"/decode/"; // 解码的路径
        path = this.getFilesDir().getAbsolutePath()+"/"+name+".mp3";
        onepath = this.getFilesDir().getAbsolutePath()+"/hehe.mp3";
        twopath = decodePath+"newlwtlwt";
        //rawAudioFile = this.getFilesDir().getAbsolutePath()+"/finish/haha.mp3";
        decodeFile = new File(decodePath);
        if (!decodeFile.exists()) {
            decodeFile.mkdirs();
        }

        btnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先开个线程解码
                //decodefile();
                encodefile();
                //播放伴奏
                //playSound();
                //点击录制音频
                //recordSound();
                //mixfile();







            }
        });

        /*btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    Log.e("mmmmmmmmmmm","暂停啦");
                    //修改播放/暂停按钮的图片为“开始播放”
                }
                //停止录制
                recorder.stop();
                //释放资源
                recorder.release();
                decodefile(path,decodePath+"/"+ name);
                decodefile(onepath,twopath);

                //解码文件
                mixfile();
                //混合文件
                encodefile();
                //转码文件


            }
        });*/




        myHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 2://下载数据完成，将下载好的数据显示在页面上
                        //1. 当解码完成后开始录音和播放
                        String str = (String)msg.obj;
                        Log.e("hahh",str);


                        break;
                }
            }
        };
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initMediaPlayer() {
        //MediaPlayer对象初始化
        mediaPlayer = new MediaPlayer();
        //AssetManager对象获取
        assetManager = getAssets();
        try {
            AssetFileDescriptor descriptor =
                    assetManager.openFd("hehe.mp3");
            //给MediaPlayer对象设置音频数据源为当前MP3
            mediaPlayer.setDataSource(descriptor);
            //加载准备好
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }




    /**
     * 开始录制音频
     */
    private void recordSound() {
        new Thread() {
            @Override
            public void run() {

                //初始化MediaRecorder对象
                recorder = new
                        MediaRecorder();
                //设置录制音频来源
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                //设置音频类型（音频格式）
                recorder.setOutputFormat(
                        MediaRecorder.OutputFormat.THREE_GPP);
                //设置音频编码方式（注意：必须先设置类型（音频格式），后设置音频编码）
                recorder.setAudioEncoder(
                        MediaRecorder.AudioEncoder.DEFAULT);
                //设置音频输入路径及音频名称
                recorder.setOutputFile(path);
                try {
                    //准备录制
                    recorder.prepare();
                } catch (
                        IOException e) {
                    e.printStackTrace();
                }
                //开始录制
                recorder.start();
            }
        }.start();
    }


    /**
     * 开始播放音频
     */
    private void playSound() {
        new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                initMediaPlayer();

            }
        }.start();
    }


    /**
     * 给录音解码
     */
    private void decodefile(final String apath, final String bpath){
        new Thread(){
            @Override
            public void run() {
                //String decodeFilePath = decodePath+"/"+ name +".pcm";
                //String decodeFilePath = decodePath+"/"+ name;
                //要解码路径
                AudioDecoder audioDec = AudioDecoder
                        .createDefualtDecoder(apath);
                try {
                    audioDec.decodeToFile(bpath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Message msg = myHandler.obtainMessage();
                //设置Message对象的属性（what、obj）
                msg.what = 1;
                msg.obj = "哈哈哈哈";
                //发送Message对象
                myHandler.sendMessage(msg);
            }
        }.start();
    }

    /**
     * 将合成后的再转码
     */
    private void encodefile(){
        new Thread(){
            @Override
            public void run() {

                AudioEncoder accEncoder = AudioEncoder
                        .createAccEncoder(getFilesDir().getAbsolutePath() + "/decode/lwt");
                //String finalMixPath = rawAudioFile;
                String finalMixPath = getFilesDir().getAbsolutePath() + "/rrrrriiiiiib.mp3" ;
                accEncoder.encodeToFile(finalMixPath);

                Message msg = myHandler.obtainMessage();
                //设置Message对象的属性（what、obj）
                msg.what = 2;
                msg.obj = "啦啦啦啦啦";
                //发送Message对象
                myHandler.sendMessage(msg);
            }
        }.start();
    }


    /*private void mixfile(){
        new Thread(){
            @Override
            public void run() {

                // 将需要合音的音频解码后的文件放到数组里
                File[] rawAudioFiles = new File[2];
                StringBuilder sbMix = new StringBuilder();
                rawAudioFiles[0] = new File(decodePath+ name);
                rawAudioFiles[1] = new File(decodePath+"newlwtlwt");
                final String mixFilePath = getFilesDir().getAbsolutePath() + "/mix/mix22222";


                // 下面的都是合音的代码
                try {
                    MultiAudioMixer audioMixer = MultiAudioMixer.createAudioMixer();

                    audioMixer.setOnAudioMixListener(new MultiAudioMixer.OnAudioMixListener() {

                        FileOutputStream fosRawMixAudio = new FileOutputStream(
                                mixFilePath);

                        @Override
                        public void onMixing(byte[] mixBytes) throws IOException {
                            fosRawMixAudio.write(mixBytes);
                        }

                        @Override
                        public void onMixError(int errorCode) {
                            try {
                                if (fosRawMixAudio != null)
                                    fosRawMixAudio.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onMixComplete() {
                            try {
                                if (fosRawMixAudio != null)
                                    fosRawMixAudio.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    });
                    audioMixer.mixAudios(rawAudioFiles);
                    rawAudioFile = mixFilePath;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }



                Message msg = myHandler.obtainMessage();
                //设置Message对象的属性（what、obj）
                msg.what = 5;
                msg.obj = "哈哈哈哈";
                //发送Message对象
                myHandler.sendMessage(msg);
            }
        }.start();
    }*/


    /*private void pauseRecord() {
        try {
            //关闭录音并释放相关资源
            out.close();
            audioRecord.stop();
            audioRecord.release();
            audioRecord = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/



    /**
     * 使用audioRecorder录音
     */
    /*private void startRecord() {
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


    }*/
}