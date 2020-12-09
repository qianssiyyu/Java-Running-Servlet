package com.example.demoallexercise1130.mine.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.demoallexercise1130.R;
import com.example.demoallexercise1130.mine.beans.BanzouUser;
import com.example.demoallexercise1130.mine.beans.UserBanzouInfo;
import com.example.demoallexercise1130.mine.fragment.base.HeaderViewPagerFragment;
import com.example.demoallexercise1130.mine.utils.CustomAdapterForBanzou;
import com.example.demoallexercise1130.mine.utils.ServerConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ScrollViewFragment extends HeaderViewPagerFragment {
    private ListView lv_banzou;
    //定义存储数据的UserInfo对象
    private UserBanzouInfo userInfo;
    private Handler myHandler;

    public static ScrollViewFragment newInstance() {
        return new ScrollViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment_scrollview, container, false);
        lv_banzou= (ListView) view.findViewById(R.id.lv_banzou );
        //从服务端下载所有用户信息
        String url = ServerConfig.SERVER_ADDR + "/"
                + ServerConfig.NET_HOME + "/getUserNameForBanzou";
        String url1 = ServerConfig.SERVER_ADDR + "/"
                + ServerConfig.NET_HOME + "/TramformBanzou";
       upKeyValue(url);
       downloadUsers(url1);
       initData();
        //点击歌单跳转到该歌单页面
        lv_banzou.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //获取歌单名
                //向新的activity传递歌单名
                // 跳转到新的activity，该页面显示该歌单所有歌曲列表
            }
        });
        return view;
    }

    @Override
    public View getScrollableView() {
        return lv_banzou;
    }

    private void initData() {
        myHandler=new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1://下载数据完成，将下载好的数据显示在页面上
                        //1. 获取下载完成的数据
                        userInfo = (UserBanzouInfo) msg.obj;
                        if(null != userInfo) {
                            List<BanzouUser> users=userInfo.getUsers();
                            set(users);
                        }
                        break;
                }
            }
        };
    }
    private int  upKeyValue(final String s) {
        new Thread() {
            @Override
            public void run() {
                //向服务端提交键值对参数
                try {
                    String keyValue = "?user_name="+ServerConfig.user_name;
                    URL url = new URL(s+keyValue);
                    url.openStream();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        return 1;
    }

    private void set(List<BanzouUser> users) {
        CustomAdapterForBanzou customAdapter=new CustomAdapterForBanzou(getContext(),users,R.layout.mine_list_item_gedan);
        lv_banzou.setAdapter(customAdapter);
    }

    /**
     * 从指定的url路径下载用户信息,并通过message发布出去
     * @param url
     */
    private void downloadUsers(final String url) {
        new Thread() {
            @Override
            public void run() {
                try {
                    //1. 通过网络请求下载数据(图片要下载到本地，修改图片地址为本地地址)
                    //创建URL对象
                    URL urlPath = new URL(url);
                    //通过URL对象获取网络输入流
                    InputStream in = urlPath.openStream();
                    //读数据（Json串),循环读写方式
                    byte[] bytes = new byte[512];
                    StringBuffer buffer = new StringBuffer();
                    int len = -1;
                    while ((len = in.read(bytes, 0, bytes.length)) != -1) {
                        buffer.append(new String(bytes, 0, len));
                    }
                    String result = buffer.toString();
                    //打印下载数据的结果
                    Log.i("lww", result);
                    in.close();
                    //先将Json串解析成外部UserInfo对象
                    //创建UserInfo对象和User集合对象
                    UserBanzouInfo userInfo = new UserBanzouInfo();
                    List<BanzouUser> users = new ArrayList<>();
                    //创建外层JSONObject对象
                    JSONObject jUsers = new JSONObject(result);
                    JSONArray jArray = jUsers.getJSONArray("users");
                    //遍历JSONArray对象,解析其中的每个元素（User）
                    for (int i = 0; i < jArray.length();i++) {
                        BanzouUser user = new BanzouUser();
                        //获取当前的JSONObject对象
                        JSONObject jUser = jArray.getJSONObject(i);
                        //获取当前元素中的姓名和头像地址
                        String name = jUser.getString("username");
                        String banzou=jUser.getString("banzou");

                        //给User对象赋值
                        user.setBanzou(banzou);
                        user.setName(name);
                        //把当前的User对象添加到集合中
                        users.add(user);
                    }
                    //给UserInfo对象赋值
                    userInfo.setUsers(users);

                    //2. 通过发送Message对象，将数据发布出去
                    //获取Message对象
                    Message msg = myHandler.obtainMessage();
                    //设置Message对象的属性（what、obj）
                    msg.what = 1;
                    msg.obj = userInfo;
                    //发送Message对象
                    myHandler.sendMessage(msg);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

