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
import com.example.demoallexercise1130.mine.beans.User;
import com.example.demoallexercise1130.mine.beans.UserInfo;
import com.example.demoallexercise1130.mine.fragment.base.HeaderViewPagerFragment;
import com.example.demoallexercise1130.mine.utils.CustomAdapter;
import com.example.demoallexercise1130.mine.utils.ServerConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends HeaderViewPagerFragment {

    private ListView lv_gedans;
    //定义存储数据的UserInfo对象
    private UserInfo userInfo;
    private Handler myHandler;

    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment_listview, container, false);
        lv_gedans= (ListView) view.findViewById(R.id.lv_gedans);
        //从服务端下载所有用户信息
        String url = ServerConfig.SERVER_ADDR + "/"
                + ServerConfig.NET_HOME + "/TransformGedan";
        String url1=ServerConfig.SERVER_ADDR + "/"
                + ServerConfig.NET_HOME + "/getUserName";
        upKeyValue(url1);
        downloadUsers(url);
        initData();
        //点击歌单跳转到该歌单页面
        lv_gedans.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        return lv_gedans;
    }

    private void initData() {
        myHandler=new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1://下载数据完成，将下载好的数据显示在页面上
                        //1. 获取下载完成的数据
                        userInfo = (UserInfo) msg.obj;
                        if(null != userInfo) {
                            List<User> users=userInfo.getUsers();
                            set(users);
                        }
                        break;
                }
            }
        };
    }

    private void set(List<User> users) {
        CustomAdapter customAdapter=new CustomAdapter(getContext(),users,R.layout.mine_list_item);
        lv_gedans.setAdapter(customAdapter);
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
                    UserInfo userInfo = new UserInfo();
                    List<User> users = new ArrayList<>();
                    //创建外层JSONObject对象
                    JSONObject jUsers = new JSONObject(result);
                    JSONArray jArray = jUsers.getJSONArray("users");
                    //遍历JSONArray对象,解析其中的每个元素（User）
                    for (int i = 0; i < jArray.length();i++) {
                        User user = new User();
                        //获取当前的JSONObject对象
                        JSONObject jUser = jArray.getJSONObject(i);
                        //获取当前元素中的姓名和头像地址
                        String name = jUser.getString("username");
                        String songlist=jUser.getString("songlist");
                        String header = jUser.getString("path");
                        System.out.println(songlist);
                        //给User对象赋值
                        user.setName(name);
                        user.setPath(header);
                        user.setSonglist(songlist);
                        //把当前的User对象添加到集合中
                        users.add(user);
                    }
                    //给UserInfo对象赋值
                    userInfo.setUsers(users);
                    //通过网络下载User的头像图片，保存到本地
                    //拼接图片的服务端资源路径，进行下载
                    for (int j = 0; j < users.size(); j++) {
                        User u = users.get(j);
                        String header = u.getPath();
                        //拼接服务端地址
                        String netHeader = ServerConfig.SERVER_ADDR + header;
                        //通过网络请求下载
                        URL imgUrl = new URL(netHeader);
                        //获取网络输入流
                        InputStream imgIn = imgUrl.openStream();
                        //获取本地files目录
                        String files = getActivity().getFilesDir().getAbsolutePath();
                                //getFilesDir().getAbsolutePath();
                        String imgs = files + "/imgs";
                        //判断imgs目录是否存在
                        File dirImgs = new File(imgs);
                        if (!dirImgs.exists()) {
                            //如果目录不存在则创建
                            dirImgs.mkdir();
                        }
                        //获取图片的名称（不包含服务端路径的图片名称)
                        String[] strs = u.getPath().split("/");
                        String imgName = strs[strs.length - 1];
                        String imgPath = imgs + "/" + imgName;
                        //修改user对象的头像地址
                        u.setPath(imgPath);
                        //获取本地文件输出流
                        OutputStream out = new FileOutputStream(imgPath);
                        //循环读写
                        int b = -1;
                        while((b = imgIn.read()) != -1){
                            out.write(b);
                            out.flush();
                        }
                        //关闭流
                        imgIn.close();
                        out.close();
                    }
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

