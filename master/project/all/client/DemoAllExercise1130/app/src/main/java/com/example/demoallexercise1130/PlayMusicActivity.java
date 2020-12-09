package com.example.demoallexercise1130;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demoallexercise1130.MyApp.MyApp;

import java.io.IOException;

public class PlayMusicActivity extends AppCompatActivity {
    /**
     * windowManager对象
     */
    private WindowManager windowManager;
    /**
     * 根视野
     */
    private FrameLayout mContentContainer;
    /**
     * 浮动视野
     */
    private static View mFloatView;

    private static RelativeLayout rlBottomPlayer;
    private static ImageView ivPhoto;
    private static TextView tvSong;
    private static TextView tvSinger;
    private static ImageView ivLast;
    private static ImageView ivPOrS;
    private static ImageView ivNext;
    //定义MediaPlayer属性
    private static MediaPlayer mediaPlayer;
    //定义AssetManager属性
    private static AssetManager assetManager;
    //定义标识当前音频的id属性
    private static int curId = 1;
    //设置请求码和返回码
    private static final int REQUEST_CODE=0;
    private static final int RESPONSE_CODE=1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (MainActivity.getFirst()==1){
            findViews();
            inits();
            setListeners();
            //初始化MediaPlayer
            initMediaPlayer();
//            MainActivity.setFirst(0);
//        }


    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initMediaPlayer() {
        //MediaPlayer对象初始化
        mediaPlayer = MyApp.getMediaPlayer();
        //AssetManager对象获取
        assetManager = getAssets();
        //预加载第一首MP3
        loadMp3(1);
        //给MediaPlayer注册播放完成事件监听器(顺序播放下一首)
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //计算下一个音频文件id
                curId++;
                if(curId > 5){
                    curId = 1;
                }
                //加载音频数据源
                loadMp3(curId);
                //启动播放
                mediaPlayer.start();
            }
        });
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
            AssetFileDescriptor descriptor = assetManager.openFd(i+".mp3");
            Log.i("lxl", "loadMp3: "+i);
            tvSong.setText(i+".mp3");
            //给MediaPlayer对象设置音频数据源为当前mp3
            mediaPlayer.setDataSource(descriptor);
            //加载准备好
            mediaPlayer.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 传入图片和歌曲信息
     */
    private void inits() {
//        Intent intent = getIntent();
////        获取图片 歌曲信息
//        String photoStr = intent.getStringExtra("photo");
//        String song = intent.getStringExtra("song");
//        String singer = intent.getStringExtra("siniger");

        //TODO：如何获取图片资源
//        ivPhoto.getResources();

        //圆形加载图片
        Glide.with(this).load(R.drawable.naineone).circleCrop().into(ivPhoto);
        tvSinger.setText("a singer");
//        tvSong.setText(song);
    }

    class MyListener implements View.OnClickListener{
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.rl_bottom_player:
                    //TODO：跳转到播放页面
                    //存储上图片等信息然后通过intent传到下一个页面
                    Intent intent = new Intent(PlayMusicActivity.this,MusicDetail.class);
                    //TODO：获取图片资源，发给具体页面
                    intent.putExtra("song",tvSong.getText().toString().trim());
                    Log.i("lxl", "onClick: "+tvSong.getText().toString().trim());
                    intent.putExtra("singer",tvSinger.getText().toString().trim());
//                    Log.i("lxl", "onClick: "+tvS.getText().toString().trim());
                    int statu = mediaPlayer.isPlaying()?1:0;//是否处于播放状态
                    Log.i("lxl", "播放状态是: "+statu);
                    intent.putExtra("statu",statu+"");
                    intent.putExtra("curId",curId+"");
                    startActivityForResult(intent,REQUEST_CODE);

                    break;
                case R.id.iv_last://上一首
                    //change curId
                    curId--;
                    if (curId<1){
                        curId=5;
                    }
                    //load mediafile
                    loadMp3(curId);
                    //play
                    mediaPlayer.start();
                    //change pic to pause
                    ivPOrS.setImageResource(R.mipmap.pause);
                    break;
                case R.id.iv_next://下一首
                    //change id
                    curId++;
                    if (curId>5){
                        curId = 1;
                    }
                    //load media file
                    loadMp3(curId);
                    //play
                    mediaPlayer.start();
                    //change pic to pause
                    ivPOrS.setImageResource(R.mipmap.pause);
                    break;
                case R.id.iv_pauseOrStart://暂停/播放
                    //如果正在播放，则暂停，，否则开始播放
                    //修改背景
                    if (mediaPlayer.isPlaying()){//正在播放-》暂停
                        mediaPlayer.pause();
                        //修改图片
                        ivPOrS.setImageResource(R.mipmap.play);
                    }else {//没有正在播放，则开始播放
                        mediaPlayer.start();
                        //change Pic to pause
                        ivPOrS.setImageResource(R.mipmap.pause);
                    }
                    break;
            }
        }
    }


    private void setListeners() {
        MyListener myListener = new MyListener();
        rlBottomPlayer.setOnClickListener(myListener);
        ivLast.setOnClickListener(myListener);
        ivPOrS.setOnClickListener(myListener);
        ivNext.setOnClickListener(myListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("lxl", "onActivityResult: 成功接收到跳转信息");
        if (requestCode==REQUEST_CODE&&resultCode == RESPONSE_CODE){
            Log.i("lxl", "onActivityResult: 开始查询信息");
            //TODO：只是测试，实际传递的时候可以通过只有id，然后通过服务端进行查询
            //TODO：需要修改下id，否则切换有问题
            String songBack = data.getStringExtra("song");
            String singerBack = data.getStringExtra("singer");
            int statu = Integer.parseInt(data.getStringExtra("statu"));
            if (statu==0){//处于暂停状态
                ivPOrS.setImageResource(R.mipmap.play);
            }else {//处于播放状态
                ivPOrS.setImageResource(R.mipmap.pause);
            }
            tvSong.setText(songBack);
            tvSinger.setText(singerBack);
            curId = Integer.parseInt(data.getStringExtra("curId"));

            //TODO:处理图片
        }
    }

    private void findViews() {
        ViewGroup mDecorView = (ViewGroup) getWindow().getDecorView();
        mContentContainer = (FrameLayout) ((ViewGroup) mDecorView.getChildAt(0)).getChildAt(1);
        mFloatView =  LayoutInflater.from(getBaseContext()).inflate(R.layout.activity_play_music, null);
        rlBottomPlayer = mFloatView.findViewById(R.id.rl_bottom_player);
        ivPhoto = mFloatView.findViewById(R.id.iv_photo);
        tvSong = mFloatView.findViewById(R.id.tv_song);
        tvSinger = mFloatView.findViewById(R.id.tv_singer);
        ivLast = mFloatView.findViewById(R.id.iv_last);
        ivPOrS = mFloatView.findViewById(R.id.iv_pauseOrStart);
        ivNext = mFloatView.findViewById(R.id.iv_next);
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,200);
        layoutParams.gravity = Gravity.BOTTOM;
        mContentContainer.addView(mFloatView,layoutParams);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    /***
     * 重点，设置这个可以实现前进Activity时候的无动画切换
     * @param intent
     */
    @Override
    public void startActivity(Intent intent){
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);//设置切换没有动画，用来实现活动之间的无缝切换
        super.startActivity(intent);
    }

    /**
     *  重点，在这里设置按下返回键，或者返回button的时候无动画
     */
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(0, 0);//设置返回没有动画
    }

}