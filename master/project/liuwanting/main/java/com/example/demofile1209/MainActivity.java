package com.example.demofile1209;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button btnUp;
    private Button btnDown;
    //定义OKHTTPClient对象属性
    private OkHttpClient okHttpClient;
    //定义Handler对象属性
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUp = findViewById(R.id.uploadfile);
        btnDown = findViewById(R.id.downloadfile);
        //初始化OKHTTPClient对象
        initOkHttpClient();
        //初始化Handler
        initHandler();
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        //upFile();
                    }
                }.start();
            }
        });
        
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        downFile();
                    }
                }.start();
            }
        });
    }

    private void downFile() {
        //2 创建Request对象
        //1) 使用RequestBody封装请求数据
        //获取待传输数据对应的MIME类型
        MediaType type = MediaType.parse("text/plain");
        //创建RequestBody对象
        RequestBody reqBody = RequestBody.create(
                "decode.mp3",
                type
        );
        //2) 创建请求对象
        Request request = new Request.Builder()
                .url(ServerConfig.SERVER_HOME + "user/upfile")
                .post(reqBody)
                .build();
        //3. 创建CALL对象
        Call call = okHttpClient.newCall(request);
        //4. 提交请求并获取响应
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.i("lww", "请求失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //拿到字节流
                InputStream is = response.body().byteStream();

                int len = 0;
                File file  = new File(getFilesDir().getAbsolutePath(), "aa.mp3");
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buf = new byte[128];

                while ((len = is.read(buf)) != -1){
                    fos.write(buf, 0, len);
                }

                fos.flush();
                //关闭流
                fos.close();
                is.close();

                Message msg = handler.obtainMessage();
                msg.what = 1;
                msg.obj = "下载完成";
                handler.sendMessage(msg);
            }
        });
    }

    private void upFile() {
        File file = new File(this.getFilesDir().getAbsolutePath(),"decode.mp3");
        RequestBody requestBody = RequestBody.create(
                file, MediaType.parse("application/octet-stream"));
        Request.Builder builder = new Request.Builder();
        Request request = new Request.Builder()
                .url(ServerConfig.SERVER_HOME + "user/downfile")
//                .method("POST", formBody)
                .post(requestBody)
                .build();
        //3. 创建CALL对象
        Call call = okHttpClient.newCall(request);
        //4. 提交请求并获取响应
        try {
            Response response = call.execute();
            //获取响应的字符串信息
            String result = response.body().string();
            Message msg = handler.obtainMessage();
            msg.what = 1;
            msg.obj = result;
            handler.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    /**
     * 初始化Handler对象
     */
    private void initHandler() {
        HandlerThread handlerThread =
                new HandlerThread("MyThread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case 1://如果服务端返回的数据是字符串
                        String result = (String) msg.obj;
                        //显示在文本框中
                        Log.e("kkkkkkk",result);
                        Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT);
                        break;
                    case 2:
                        String result1 = (String) msg.obj;
                        //显示在文本框中
                        Log.e("hhhhh",result1);
                        Toast.makeText(MainActivity.this,result1,Toast.LENGTH_SHORT);
                        break;
                }
            }
        };
    }

    /**
     * 初始化OKHTTPClient对象
     */
    private void initOkHttpClient() {
        //okHttpClient = new OkHttpClient();
        //使用Builder对象创建OKHTTPClient对象的方法如下：
//        okHttpClient = new OkHttpClient.Builder()
//                //可以添加网络请求参数，如网络超时连接时间等
//                .build();

        okHttpClient= new OkHttpClient.Builder().
                connectTimeout(60000, TimeUnit.MILLISECONDS)
                .readTimeout(60000, TimeUnit.MILLISECONDS)
                .build();
    }


}