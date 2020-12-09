package com.example.demoallexercise1130.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Explode;

import com.bumptech.glide.Glide;
import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.adapter.HotSongAdapter;
import com.example.demoallexercise1130.adapter.OneSingerAdapter;
import com.example.demoallexercise1130.adapter.OneSongAdapter;
import com.example.demoallexercise1130.entity.Musician;
import com.example.demoallexercise1130.entity.Song;
import com.example.demoallexercise1130.util.ServerConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.loader.ImageLoaderInterface;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class SecondFragment extends Fragment {
    private Banner banner;
    private ArrayList<Integer> list_path;
    private ArrayList<String> list_title;
    private List<Song> list = new ArrayList<>();
    private List<Musician> mlist = new ArrayList<>();
    private List<Song> list2 = new ArrayList<>();
    private View view;
    private RecyclerView recyclerView;
    private VideoView vvMylike;
    //定义Gson对象属性
    private Gson gson;
    //定义OKHTTPClient对象属性
    private OkHttpClient okHttpClient;
    //定义Handler对象属性
    private Handler handler;
    private RecyclerView rvHsinger;
    private ListView hotSong;
    private JZVideoPlayerStandard jp;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.secondfragment, null);
        initView();
        recyclerView = view.findViewById(R.id.rvHotsong);
        rvHsinger = view.findViewById(R.id.rvhSinger);
        hotSong = view.findViewById(R.id.rvhS);
        TextView tvContent = view.findViewById(R.id.more_content);
        jp = view.findViewById(R.id.jp);


        init();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        LinearLayoutManager layoutManager1=new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        rvHsinger.setLayoutManager(layoutManager1);
        recyclerView.setAdapter(new HotSongAdapter(getContext(),list));
        rvHsinger.setAdapter(new OneSingerAdapter(getContext(),mlist));
        hotSong.setAdapter(new OneSongAdapter(getContext(),list2,R.layout.onesong_item));

        //initOkHttpClient();
        //initGson();
        /*handler = new Handler(Looper.getMainLooper()) {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1://下载数据完成，将下载好的数据显示在页面上
                        String result = (String) msg.obj;


                        break;
                }
            }
        };*/
        tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        jp.setUp(getContext().getFilesDir().getAbsolutePath()+"/likevideo.mp4/",JZVideoPlayerStandard.SCREEN_WINDOW_FULLSCREEN,"易烊千玺");
        jp.thumbImageView.setImageResource(R.drawable.im1);
        jp.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //translateuinfo("1");
        return view;
    }

    private void initView() {
        banner = view. findViewById(R.id.banner);
        //放图片地址的集合
        list_path = new ArrayList<Integer>();
        //放标题的集合
        list_title = new ArrayList<>();

        list_path.add(R.drawable.i1);
        list_path.add(R.drawable.i2);
        list_path.add(R.drawable.i3);
        list_path.add(R.drawable.banner);
//        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604551889874&di=03985b9a01e5d3a7836f54dba585dea5&imgtype=0&src=http%3A%2F%2Fqqpublic.qpic.cn%2Fqq_public%2F0%2F0-3242360399-1A85946A9AA864064804F578294090CE%2F0%3Ffmt%3Djpg%26amp%3Bsize%3D40%26amp%3Bh%3D609%26amp%3Bw%3D900%26amp%3Bppv%3D1");
//        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604551889872&di=e96268d0e15fea233052f18603126e15&imgtype=0&src=http%3A%2F%2Fqqpublic.qpic.cn%2Fqq_public%2F0%2F0-3969778974-ADB898C84C76E03E2C3DDF41D6CF723F%2F0%3Ffmt%3Djpg%26size%3D56%26h%3D506%26w%3D900%26ppv%3D1");
//        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604551889870&di=f0ab05c3b6e3edbff83adafb715a6a4c&imgtype=0&src=http%3A%2F%2Fqqpublic.qpic.cn%2Fqq_public%2F0%2F0-4203551577-AD16926FCCA9359B152DBB6F4DFAF112%2F0%3Ffmt%3D%26amp%3Bsize%3D0%26amp%3Bh%3D429%26amp%3Bw%3D640%26amp%3Bppv%3D1");
//        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604551889871&di=e07ceba66fdc613a0ac27c3ceeadbee8&imgtype=0&src=http%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%253A%252F%252Fdingyue.ws.126.net%252F2020%252F0926%252F20b38ecbp00qh8obu009vc000pn00fkm.png%26thumbnail%3D650x2147483647%26quality%3D80%26type%3Djpg");
        list_title.add("万物皆可说唱");
        list_title.add("万物皆可说唱");
        list_title.add("万物皆可说唱");
        list_title.add("万物皆可说唱");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader((ImageLoaderInterface) new SecondFragment.MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this::OnBannerClick)
                //必须最后调用的方法，启动轮播图。
                .start();


    }
    //轮播图的监听方法
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第"+position+"张轮播图");
    }
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path).into(imageView);
        }
    }


    private void init(){
        Song s1 = new Song();
        s1.setImgpath("im1.jpg");
        s1.setName("想把你藏进外套里,陪伴你度过漫漫长夜哈哈哈哈哈哈哈哈哈");
        list.add(s1);
        Song s2 = new Song();
        s2.setName("想把你藏进外套里,陪伴你度过漫漫长夜哈哈哈哈哈哈哈哈哈");
        s2.setImgpath("im2.jpg");
        list.add(s2);
        Song s3 = new Song();
        s3.setName("想把你藏进外套里,陪伴你度过漫漫长夜哈哈哈哈哈哈哈哈哈");
        s3.setImgpath("im2.jpg");
        list.add(s3);
        Song s4 = new Song();
        s4.setName("想把你藏进外套里,陪伴你度过漫漫长夜哈哈哈哈哈哈哈哈哈");
        s4.setImgpath("im2.jpg");
        list.add(s4);
        Song s5 = new Song();
        s5.setName("想把你藏进外套里,陪伴你度过漫漫长夜哈哈哈哈哈哈哈哈哈");
        s5.setImgpath("im2.jpg");
        list.add(s5);
        Musician m1 = new Musician();
        m1.setName("易烊千玺");
        m1.setPhotoId("im5.jpg");
        Musician m2 = new Musician();
        m2.setName("易烊千玺");
        m2.setPhotoId("im5.jpg");
        Musician m3 = new Musician();
        m3.setName("易烊千玺");
        m3.setPhotoId("im5.jpg");
        mlist.add(m1);
        mlist.add(m2);
        mlist.add(m3);
        Musician m4 = new Musician();
        m4.setName("易烊千玺");
        m4.setPhotoId("im5.jpg");
        Musician m5 = new Musician();
        m5.setName("易烊千玺");
        m5.setPhotoId("im5.jpg");
        mlist.add(m4);
        mlist.add(m5);

        Song p1 = new Song();
        p1.setImgpath("im1.jpg");
        p1.setName("粉雾海");
        p1.setAuthor("易烊千玺");
        list2.add(p1);
        Song p2 = new Song();
        p2.setImgpath("im1.jpg");
        p2.setName("粉雾海");
        p2.setAuthor("易烊千玺");
        list2.add(p2);
        Song p3 = new Song();
        p3.setImgpath("im1.jpg");
        p3.setName("粉雾海myboo");
        p3.setAuthor("易烊千玺");
        list2.add(p3);

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
     * 初始化OKHTTPClient对象
     */
    private void initOkHttpClient() {
        okHttpClient = new OkHttpClient();
        //使用Builder对象创建OKHTTPClient对象的方法如下：
//        okHttpClient = new OkHttpClient.Builder()
//                //可以添加网络请求参数，如网络超时连接时间等
//                .build();
    }

    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }


}
