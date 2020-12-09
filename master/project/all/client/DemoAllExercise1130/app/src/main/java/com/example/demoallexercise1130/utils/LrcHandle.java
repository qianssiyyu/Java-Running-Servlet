package com.example.demoallexercise1130.utils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LrcHandle {
    private List<String> mWords = new ArrayList();
    private List<Integer> mTimeList = new ArrayList();
//    private OkHttpClient okHttpClient = new OkHttpClient();

    //处理歌词文件
    public void readLRC(String path){
        File file = new File(path);
        try {
            Log.i("lxl", "readLRC: try块");
            FileInputStream fileInputStream = new FileInputStream(file);
            Log.i("lxl", "readLRC: 构建fileinput");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GB2312");
            Log.i("lxl", "readLRC: 构建inputStreamReader");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            Log.i("lxl", "readLRC: 试试bufferedReader");
            String s = "";
            while ((s = bufferedReader.readLine())!=null){
                Log.i("lxl", "readLRC: "+s);
                addTimeToList(s);
                if ((s.indexOf("[ar:")!=-1)||(s.indexOf("[ti:")!=-1)||(s.indexOf("[by:")!=-1)){
                    s = s.substring(s.indexOf(":")+1,s.indexOf("]"));
                }else {
                    String ss = s.substring(s.indexOf("["),s.indexOf("]")+1);
                    s = s.replace(ss,"");
                }
                mWords.add(s);
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            mWords.add("没有歌词文件，请先下载");
            Log.i("lxl", "readLRC: 没有找到文件");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            mWords.add("没有读取到歌词文件");
        }
    }

    public List getmWords(){
        return mWords;
    }
    public List getmTimeList(){
        return mTimeList;
    }

    /**
     * 解析歌词时间
     * 歌词内容格式如下：
     * [00:02.32]陈奕迅
     * [00:03.43]好久不见
     * [00:05.22]歌词制作  王涛
     * @param timeStr
     * @return
     */
    private int timeHandler(String timeStr){
        //这两行代码是为了统一分隔符
        timeStr = timeStr.replace(":", ".");
        timeStr = timeStr.replace(".", "@");

        String timeData[] = timeStr.split("@");	//将时间分隔成字符串数组



        //分离出分、秒并转换为整型
        int minute = Integer.parseInt(timeData[0]);
        int second = Integer.parseInt(timeData[1]);
        Log.i("lxl分离出的秒是", "timeHandler: "+second);
        int millisecond = Integer.parseInt(timeData[2]);

        //计算上一行与下一行的时间转换为毫秒数
        int currentTime = (minute * 60 + second) * 1000 + millisecond * 10;

        return currentTime;

    }

    /**
     * @param s
     */
    private void addTimeToList(String s) {
        Matcher matcher = Pattern.compile("\\[\\d{1,2}:\\d{1,2}([\\.:]\\d{1,2})?\\]").matcher(s);
        if (matcher.find()){
            String str = matcher.group();
            Log.i("lxl addTimeTOList中的字符串是", "addTimeToList: "+str);
            mTimeList.add(new LrcHandle().timeHandler(str.substring(1,str.length()-1)));
        }
    }
}
