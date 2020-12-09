package com.example.demoallexercise1130;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;


import com.example.demoallexercise1130.util.ServerConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btGo;
    private CardView cv;
    private FloatingActionButton fab;
    //定义Gson对象属性
    private Gson gson;
    //定义OKHTTPClient对象属性
    private OkHttpClient okHttpClient;
    //定义Handler对象属性
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initView();
        //initHandler();
        //initOkHttpClient();
        setListener();
        /*initGson();
        handler = new Handler(Looper.getMainLooper()) {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1://下载数据完成，将下载好的数据显示在页面上
                        String result = (String) msg.obj;

                        Log.e("ajjajajajajajaj",result);
                        if(result.equals("true")) {
                            Explode explode = new Explode();
                            explode.setDuration(500);
                            getWindow().setExitTransition(explode);
                            getWindow().setEnterTransition(explode);
                            ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
                            Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i2, oc2.toBundle());
                        }
                        break;
                }
            }
        };*/
    }

    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btGo = findViewById(R.id.bt_go);
        cv = findViewById(R.id.cv);
        fab = findViewById(R.id.fab);
    }

    private void setListener(){

        btGo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                //先判断手机号是不是11位
                String num = etUsername.getText().toString();
                if(num.length()==11){
                    Log.e("remind","手机号码正确");
                    Explode explode = new Explode();
                    explode.setDuration(500);
                    getWindow().setExitTransition(explode);
                    getWindow().setEnterTransition(explode);
                    ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
                    Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i2, oc2.toBundle());
                    /*User user = new User();
                    user.setPhone(num);
                    user.setPwd(etPassword.getText().toString());
                    //student对象序列化
                    String json = gson.toJson(user);
                    translateuinfo(json);*/
                    //Log.e("remind","手机号码正确11111");

                }else if(num.length()==0){
                    Log.e("remind","手机号不能为空");
                }else{
                    Log.e("remind","手机号位数错误");
                }

                //将手机号、密码封装成对象，转成json串，利用okhttp

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, fab, fab.getTransitionName());
                startActivity(new Intent(LoginActivity.this, ActivityTwo.class), options.toBundle());
            }
        });
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onRestart() {
        super.onRestart();
        fab.setVisibility(View.GONE);
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onResume() {
        super.onResume();
        fab.setVisibility(View.VISIBLE);
    }

    public void translateuinfo(final String str){
        new Thread(){
            @Override
            public void run() {
                //无参数的同步的Get请求
//                        withNoParamGetRequest();
                //url末尾带参数的异步的Get请求
//                        paramInUrlAsyncGetRequest();
                //提交Form表单参数的同步Post请求
//                        formParamPostRequest();
                //提交普通字符串数据
                simpStringParamPostRequest(str);
            }
        }.start();

    }


    /**
     * 采用POST请求方式提交普通的字符串数据
     */
    private void simpStringParamPostRequest(String str) {
        //2 创建Request对象
        //1) 使用RequestBody封装请求数据
        //获取待传输数据对应的MIME类型
        Log.e("oooooooooooo",str);
        MediaType type = MediaType.parse("text/plain");
        //创建RequestBody对象
        RequestBody reqBody = RequestBody.create(
                str,
                type
        );
        //2) 创建请求对象
        Request request = new Request.Builder()
                .url(ServerConfig.SERVER_HOME + "user/login")
                .post(reqBody)
                .build();
        Log.i("lallll",ServerConfig.SERVER_HOME + "user/login");
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
                String result = response.body().string();

                Message msg = handler.obtainMessage();
                msg.what = 1;
                msg.obj = result;
                handler.sendMessage(msg);
            }
        });
    }

    private void initGson() {
//        gson = new Gson();
        //允许配置参数的Gson对象初始化
        gson = new GsonBuilder()//创建GsonBuilder对象
                .setPrettyPrinting()//格式化输出
                .serializeNulls()//允许输出Null值属性
                .setDateFormat("YY:MM:dd")//日期格式化
                .create();//创建Gson对象
    }

    /**
     * 初始化Handler对象
     */
    /*private void initHandler() {
        HandlerThread handlerThread =
                new HandlerThread("MyThread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper()){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case 1://如果服务端返回的数据是字符串
                        String result = (String) msg.obj;
                        Log.e("ajjajajajajajaj",result);
                        Explode explode = new Explode();
                explode.setDuration(500);

                getWindow().setExitTransition(explode);
                getWindow().setEnterTransition(explode);
                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(ActivityOne.this);
                Intent i2 = new Intent(ActivityOne.this, ActivityThree.class);
                startActivity(i2, oc2.toBundle());

                        break;
                    case 2:
                        break;
                }
            }
        };
    }*/


    /**
     * 初始化OKHTTPClient对象
     */
    private void initOkHttpClient() {
        okHttpClient = new OkHttpClient();
        //使用Builder对象创建OKHTTPClient对象的方法如下：
//        okHttpClient = new OkHttpClient.Builder()
//                //可以添加网络请求参数，如网络超时连接时间等
//                .build();
    }


}