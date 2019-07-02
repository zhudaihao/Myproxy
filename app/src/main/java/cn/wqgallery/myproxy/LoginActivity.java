package cn.wqgallery.myproxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.wqgallery.myproxy.util.SharePreferenceUtil;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    //首页
    public void click1(View view) {
        SharePreferenceUtil.setBooleanSp("login", true, this);
        finish();
    }


}
