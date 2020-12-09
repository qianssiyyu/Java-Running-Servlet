package com.example.demoallexercise1130.MyApp;

import android.app.Application;
import android.media.MediaPlayer;

public class MyApp extends Application {
    private static MediaPlayer mediaPlayer= new MediaPlayer();
    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }


}
