package com.example.demoallexercise1130;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demoallexercise1130.MyApp.MyApp;
import com.example.demoallexercise1130.adapter.ListPlayAdapter;
import com.example.demoallexercise1130.entity.PlayOrder;
import com.example.demoallexercise1130.entity.SongModel;
import com.example.demoallexercise1130.mine.MineActivity;
import com.example.demoallexercise1130.util.ImageFilter;
import com.example.demoallexercise1130.utils.LrcHandle;
import com.example.demoallexercise1130.utils.WordView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicDetail extends AppCompatActivity {

    private LinearLayout llAll;

    //顶端两个小工具
    private ImageView ivBack;
    private ImageView ivMore;

    //图片 歌名 歌手
    private LinearLayout llPicSS;
    private ImageView ivPhoto;
    private TextView tvSong;
    private TextView tvSinger;

    //进度条
    private SeekBar seekbar;
    private TextView tvStart;
    private TextView tvEnd;

    //播放小工具 上一首 播放/暂停 下一首
    private ImageView ivLast;
    private ImageView ivPOrS;
    private ImageView ivNext;

    //底端小工具
    private ImageView ivPlayOrder;
    private ImageView ivToLike;
    private ImageView ivSongList;

    //定义MediaPlayer属性
    private MediaPlayer mediaPlayer;
    //定义AssetManager属性
    private AssetManager assetManager;
    //定义标识当前音频的id属性  用传入的数据
    private int curId;
    //播放状态
    private int statu;
    private int duration;
    private int position;

    private PopupWindow popupWindow;
    //更新进度条
    private int statuBar;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
//                    View rootView = LayoutInflater.from(MusicDetail.this).inflate(R.layout.activity_music_detail,null);
                    View rootView = (View) msg.obj;
                    popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.TOP,0,-100);
                    popupWindow.update();
                    break;
            }
        }
    };
    Runnable updateThread = new Runnable() {
        public void run() {
            //进度条 和 时间
            //获得歌曲的长度并设置成播放进度条的最大值
            seekbar.setMax(mediaPlayer.getDuration());
            //获得歌曲现在播放位置并设置成播放进度条的值
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            duration = mediaPlayer.getDuration() / 1000;//获取音乐总时长
            position = mediaPlayer.getCurrentPosition();//获取当前播放的位置
            tvStart.setText(calculateTime(position / 1000));//开始时间
            tvEnd.setText(calculateTime(duration));//总时长
            //每次延迟1000毫秒再启动线程
            handler.postDelayed(updateThread, 1000);
        }
    };


    //歌词部分
    private Boolean b=false;//用于记录是否是同一首歌
    private LrcHandle lrcHandler;
    private WordView mWordView;
    private List mTimeList;
    final Handler handler1 = new Handler();
    Thread thread =  new Thread(new Runnable() {
        int i = 0;
        @Override
        public void run() {
            while (mediaPlayer.isPlaying()) {
                handler1.post(new Runnable() {
                    @Override
                    public void run() {
                        //invalidate 绘制 调用onDraw
                        mWordView.invalidate();
                        Log.i("lxl", "run: 执行了invalidate方法");
                    }
                });
                Log.i("lll", "run: 准备执行try");
                try {
                    Log.i("lll", "run: 执行try");
                    Log.i("查看时间", "run: " + mTimeList.get(i + 1).toString());
                    int a = Integer.parseInt(mTimeList.get(i + 1).toString()) - Integer.parseInt(mTimeList.get(i).toString());
                    Log.i("等待时间", "run: " + a);
                    Thread.sleep(Integer.parseInt(mTimeList.get(i + 1).toString()) - Integer.parseInt(mTimeList.get(i).toString()));
//                        Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.i("阻塞", "run: 时间转换被阻塞");
                    e.printStackTrace();
                }
                i++;
                if (i == mTimeList.size() - 1) {//最后一句，结尾
                    mediaPlayer.pause();
                    break;
                }
            }
        }
    });


    private boolean isliked;//初始情况为没有点赞
    private PlayOrder playOrder;//播放顺序设置，初始化为ByOrdered；


    @SuppressWarnings("SdCardPath")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        Log.i("lxl", "onCreate: 成功跳转");
        findViews();
        Log.i("lxl", "onCreate: 成功跳转1");
        initViews();
        //进度条小工具
        initSeekBarListener();
        Log.i("lxl", "onCreate: 成功初始化");
        setListeners();
        Log.i("lxl", "onCreate: 成功设置监听器");
        //启动
        handler.post(updateThread);
//        initLyrics(getBaseContext().getFilesDir().getPath() + "/test.lrc");

    }

    /**
     *
     * @param path
     */
    private void initLyrics(String path) {

        if (!b){//不是同一首歌的时候，重现加载
            lrcHandler.readLRC(path);
            mTimeList = lrcHandler.getmTimeList();
            b=true;
        }

        thread.start();
    }
    //计算播放时间
    public String calculateTime(int time) {
        int minute;
        int second;
        if (time > 60) {
            minute = time / 60;
            second = time % 60;
            //分钟再0~9
            if (minute >= 0 && minute < 10) {
                //判断秒
                if (second >= 0 && second < 10) {
                    return "0" + minute + ":" + "0" + second;
                } else {
                    return "0" + minute + ":" + second;
                }
            } else {
                //分钟大于10再判断秒
                if (second >= 0 && second < 10) {
                    return minute + ":" + "0" + second;
                } else {
                    return minute + ":" + second;
                }
            }
        } else if (time < 60) {
            second = time;
            if (second >= 0 && second < 10) {
                return "00:" + "0" + second;
            } else {
                return "00:" + second;
            }
        }
        return null;
    }


    private void initSeekBarListener() {
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if (b) {
                    mediaPlayer.seekTo(progress);
                    duration = mediaPlayer.getDuration() / 1000;//获取音乐总时长
                    position = mediaPlayer.getCurrentPosition();//获取当前播放的位置
                    tvStart.setText(calculateTime(position / 1000));//开始时间
                    tvEnd.setText(calculateTime(duration));//总时长
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * 接收从底部播放器接收到的数据
     */
    private void initViews() {
        playOrder = PlayOrder.ByOrder;//初始化为顺序播放
        isliked = false;
        lrcHandler = new LrcHandle();
        //默认没有启动handler
        statuBar = 0;
        //MediaPlayer对象初始化
        mediaPlayer = MyApp.getMediaPlayer();
        //AssetManager对象获取
        assetManager = getAssets();
        Intent intent = getIntent();
        String song = intent.getStringExtra("song");
        String singer = intent.getStringExtra("singer");
        statu = Integer.parseInt(intent.getStringExtra("statu"));
        if (statu == 0) {//未播放
            ivPOrS.setImageResource(R.mipmap.play_dark);
        } else {//正在播放
            ivPOrS.setImageResource(R.mipmap.pause_dark);
        }
        Log.i("lxl", "initViews: curid" + intent.getStringExtra("curId"));
        Log.i("lxl", "initViews: song" + intent.getStringExtra("song"));
        Log.i("lxl", "initViews: singer" + intent.getStringExtra("singer"));
        curId = Integer.parseInt(intent.getStringExtra("curId"));
        tvSong.setText(song);
        tvSinger.setText(singer);
//        可以不用glide
//        Glide.with(this).load(R.drawable.naineone).circleCrop().into(ivPhoto);
        Glide.with(this).load(R.drawable.naineone).into(ivPhoto);


        //模糊
        Resources res = this.getResources();
//拿到初始图
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.naineone);
//处理得到模糊效果的图
        Bitmap blurBitmap = ImageFilter.blurBitmap(this, bmp, 20f);
        llAll.setBackground(new BitmapDrawable(getResources(), blurBitmap));
    }

    /**
     * 预加载音乐
     * @param i
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void loadMp3(int i) {
        try {
            //重置MediaPlayer
            mediaPlayer.reset();
            //获取当前指定mp3文件
            AssetFileDescriptor descriptor = assetManager.openFd(i + ".mp3");
            Log.i("lxl", "loadMp3: " + i);
            tvSong.setText(i + ".mp3");
            //给MediaPlayer对象设置音频数据源为当前mp3
            mediaPlayer.setDataSource(descriptor);
            //加载准备好
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class MyListener implements View.OnClickListener {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.seekBar:
                    //点击事件已有单独方法处理
                    Log.i("lxl", "onClick: 点击了seekbar");
                    break;
                case R.id.ll_pic_ss:
                    Log.i("lxl", "onClick: 点击了图片歌手的布局");
                    llPicSS.setVisibility(View.GONE);
                    mWordView.setVisibility(View.VISIBLE);

                    break;
                case R.id.lrc_ShowView:
                    Log.i("lxl", "onClick: 点击了歌词的布局");
                    mWordView.setVisibility(View.GONE);
                    llPicSS.setVisibility(View.VISIBLE);
                    break;

                case R.id.iv_back:
                    onBackPressed();
                    break;
                case R.id.iv_more:
                    Intent intent = new Intent(MusicDetail.this, MineActivity.class);
                    startActivity(intent);
                    break;
                case R.id.iv_last://上一首
                    //change curId
                    curId--;
                    if (curId < 1) {
                        curId = 5;
                    }
                    //load mediafile
                    loadMp3(curId);
                    //play
                    mediaPlayer.start();
                    initLyrics(getBaseContext().getFilesDir().getPath() + "/test.lrc");
                    //change pic to pause
                    ivPOrS.setImageResource(R.mipmap.pause_dark);
                    break;
                case R.id.iv_next://下一首
                    //change id
                    curId++;
                    if (curId > 5) {
                        curId = 1;
                    }
                    //load media file
                    loadMp3(curId);
                    //play
                    mediaPlayer.start();
                    initLyrics(getBaseContext().getFilesDir().getPath() + "/test.lrc");
                    //change pic to pause
                    ivPOrS.setImageResource(R.mipmap.pause_dark);
                    break;
                case R.id.iv_pauseOrStart://暂停/播放
                    //如果正在播放，则暂停，，否则开始播放
                    //修改背景
                    if (mediaPlayer.isPlaying()) {//正在播放-》暂停
                        mediaPlayer.pause();
                        //修改状态
                        statu = 0;
                        //修改图标
                        ivPOrS.setImageResource(R.mipmap.play_dark);
                    } else {//没有正在播放，则开始播放
                        mediaPlayer.start();
                        statu = 1;
                        //change Pic to pause
                        ivPOrS.setImageResource(R.mipmap.pause_dark);
                    }
                    break;
                case R.id.iv_play_order:
                    //TODO:后端交互
                    changePlayOrder();
                    break;
                case R.id.iv_tolike:
                    //TODO：需要与服务端交互
                    //点赞之后切换图片，修改数据库，与后端交互
                    if (!isliked){
                        // TODO addToMyLike();
                        ivToLike.setImageResource(R.mipmap.liked);
                        isliked = true;
                    }else {
                        //todo deleteFromMyLike();
                        //取消点赞之后切换图片，修改数据库，与后端交互
                        ivToLike.setImageResource(R.mipmap.tolike);
                        isliked = false;
                    }
                    break;
                case R.id.iv_songlist:
                    //歌曲列表
                    Intent intent2 = new Intent(MusicDetail.this,ShowPlayListActivity.class);
                    startActivity(intent2);
//                    ShowSongsList();
                    break;
            }
        }
    }

    private void changePlayOrder() {
        //byOrder->random->single
        switch (playOrder){
            case ByOrder:
                //
                ivPlayOrder.setImageResource(R.mipmap.random_play);
                //与后端交互，修改传入的循序
                playOrder = PlayOrder.Random;
                break;
            case Random:
                //
                ivPlayOrder.setImageResource(R.mipmap.single_play);
                playOrder = PlayOrder.Single;

                break;
            case Single:
                //
                ivPlayOrder.setImageResource(R.mipmap.byorder_play);
                playOrder = PlayOrder.ByOrder;
                break;

        }
    }

    private void ShowSongsList() {
        //得到目标listview
        LayoutInflater inflater = LayoutInflater.from(getBaseContext());
        ListView listView = inflater.inflate(R.layout.songs_list, null).findViewById(R.id.lv_songs);
        //fakeDatas
        List<SongModel> list = new ArrayList<>();
        SongModel songModel = new SongModel();
        songModel.setName("first");
        songModel.setAuthor("firstAuthor");
        list.add(songModel);
        SongModel songModel1 = new SongModel();
        songModel1.setName("second");
        songModel1.setAuthor("secondAuthor");
        list.add(songModel1);
        //todo:准备歌词数据（后端交互）
        ListPlayAdapter adapter = new ListPlayAdapter(this,list, R.layout.songs_item_text);
        listView.setAdapter(adapter);
        //准备PopupWindow
        View popView = inflater.inflate(R.layout.songs_list,null);
        popupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setContentView(popView);
        //显示popUpWindow
        View rootView = LayoutInflater.from(MusicDetail.this).inflate(R.layout.activity_music_detail,null);
        Message message = handler.obtainMessage();
        message.what=0;
        message.obj=rootView;
        handler.sendMessage(message);
    }

    private void setListeners() {
        MyListener myListener = new MyListener();
        llPicSS.setOnClickListener(myListener);
        ivBack.setOnClickListener(myListener);
        ivMore.setOnClickListener(myListener);
//        ivPhoto.setOnClickListener(myListener);
        ivLast.setOnClickListener(myListener);
        ivPOrS.setOnClickListener(myListener);
        ivNext.setOnClickListener(myListener);
        ivPlayOrder.setOnClickListener(myListener);
        ivToLike.setOnClickListener(myListener);
        ivSongList.setOnClickListener(myListener);
        mWordView.setOnClickListener(myListener);
    }

    private void findViews() {
        mWordView = findViewById(R.id.lrc_ShowView);
        llAll = findViewById(R.id.ll_all);
        seekbar = findViewById(R.id.seekBar);
        llPicSS = findViewById(R.id.ll_pic_ss);
        ivBack = findViewById(R.id.iv_back);
        ivMore = findViewById(R.id.iv_more);
        ivPhoto = findViewById(R.id.iv_photo);
        ivLast = findViewById(R.id.iv_last);
        ivNext = findViewById(R.id.iv_next);
        ivPOrS = findViewById(R.id.iv_pauseOrStart);
        tvSong = findViewById(R.id.tv_song);
        tvSinger = findViewById(R.id.tv_singer);
        ivPlayOrder = findViewById(R.id.iv_play_order);
        ivToLike = findViewById(R.id.iv_tolike);
        ivSongList = findViewById(R.id.iv_songlist);
        tvStart = findViewById(R.id.tv_start);
        tvEnd = findViewById(R.id.tv_end);
    }

    //TODO：动画效果
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        backToBottom();
        super.onBackPressed();
    }

    private void backToBottom() {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        intent.putExtra("song", tvSong.getText().toString().trim());
        Log.i("lxl", "backToBottom: 现在播放的是" + tvSong.getText().toString().trim());
        intent.putExtra("singer", tvSinger.getText().toString().trim());
        intent.putExtra("statu", statu + "");
        intent.putExtra("curId", curId + "");
        Log.i("lxl", "backToBottom: 现在的播放状态是" + statu);
        setResult(1, intent);
    }
}







