package com.example.demoallexercise1130;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.CardView;
import android.os.Handler;
import android.os.Message;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.demoallexercise1130.entity.User;
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

//import cn.fanrunqi.materiallogin.R;

public class ActivityTwo extends AppCompatActivity {

    private FloatingActionButton fab;
    private CardView cvAdd;
    private EditText etPwd;
    private EditText etRepwd;
    private Button btnGo;
    private EditText userName;
    //定义Gson对象属性
    private Gson gson;
    //定义OKHTTPClient对象属性
    private OkHttpClient okHttpClient;
    //定义Handler对象属性
    private Handler handler;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_two);
        ShowEnterAnimation();
        initView();
        //initOkHttpClient();
        //initGson();
        /*handler = new Handler(Looper.getMainLooper()) {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1://下载数据完成，将下载好的数据显示在页面上
                        String result = (String) msg.obj;

                        Log.e("ajjajajajajajaj",result);
                        if(result.equals("true")) {
                            Intent i = new Intent();
                            i.setClass(ActivityTwo.this,LoginActivity.class);
                            startActivity(i);

                        }
                        break;
                }
            }
        };*/
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                animateRevealClose();
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setPhone(userName.getText().toString());
                user.setPwd(etPwd.getText().toString());
                //student对象序列化
                String json = gson.toJson(user);
                //translateuinfo(json);

            }
        });


    }

    private void initView() {
        btnGo  = findViewById(R.id.bt_go);
        userName = findViewById(R.id.et_username);
        etPwd = findViewById(R.id.et_password);
        fab = findViewById(R.id.fab);
        cvAdd = findViewById(R.id.cv_add);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void ShowEnterAnimation() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fabtransition);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setSharedElementEnterTransition(transition);
        }

        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                cvAdd.setVisibility(View.GONE);
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                animateRevealShow();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }


        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void animateRevealShow() {
        Animator mAnimator = ViewAnimationUtils.createCircularReveal(cvAdd, cvAdd.getWidth()/2,0, fab.getWidth() / 2, cvAdd.getHeight());
        mAnimator.setDuration(500);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                cvAdd.setVisibility(View.VISIBLE);
                super.onAnimationStart(animation);
            }
        });
        mAnimator.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void animateRevealClose() {
        Animator mAnimator = ViewAnimationUtils.createCircularReveal(cvAdd,cvAdd.getWidth()/2,0, cvAdd.getHeight(), fab.getWidth() / 2);
        mAnimator.setDuration(500);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cvAdd.setVisibility(View.INVISIBLE);
                super.onAnimationEnd(animation);
                fab.setImageResource(R.drawable.plus);
                ActivityTwo.super.onBackPressed();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        mAnimator.start();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
        animateRevealClose();
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
                simpParamPostRequest(str);
            }
        }.start();

    }

    private void simpParamPostRequest(String str) {
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
                .url(ServerConfig.SERVER_HOME + "user/register")
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
