package cn.wqgallery.myproxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.reflect.Proxy;

import cn.wqgallery.myproxy.proxy.ILogin;
import cn.wqgallery.myproxy.proxy.MyProxyHandler;

public class MainActivity extends AppCompatActivity implements ILogin {
    //定义接口对象
    private ILogin iLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        /**
         * 创建代理对象
         *  参数（类加载器，接口数组，代理handler）
         *
         */
        iLogin = (ILogin) Proxy.newProxyInstance(
                getClassLoader(),
                new Class[]{ILogin.class},
                new MyProxyHandler(this)
        );
    }


    //首页
    public void click1(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    //购物
    public void click2(View view) {
        iLogin.alreadyLogged("1");
    }


    //个人信息
    public void click3(View view) {
        iLogin.alreadyLogged("2");
    }

    //已经登录逻辑处理
    @Override
    public void alreadyLogged(String tag) {
        switch (tag) {
            case "1":
                //已登录 跳转到购物页面
                startActivity(new Intent(this, ShopActivity.class));
                break;

            case "2":
                //已登录 跳转到个人信息
                startActivity(new Intent(this, UserActivity.class));
                break;
        }

    }
}
