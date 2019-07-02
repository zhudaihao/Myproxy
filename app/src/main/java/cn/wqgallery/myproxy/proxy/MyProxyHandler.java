package cn.wqgallery.myproxy.proxy;

import android.content.Context;
import android.content.Intent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import cn.wqgallery.myproxy.LoginActivity;
import cn.wqgallery.myproxy.util.SharePreferenceUtil;

/**
 * 代理拦截器
 */
public class MyProxyHandler implements InvocationHandler {
    private Object object;
    private Context context;

    public MyProxyHandler(Context context) {
        this.object = context;
        this.context = context;
    }

    /**
     * 拦截调用接口方法 的方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        if (SharePreferenceUtil.getBooleanSp("login", context)) {
            //登录了 拦截  (执行接口方法)
            invoke = method.invoke(object, args);
        } else {
            //没有登录 跳转登录页面
            context.startActivity(new Intent(context, LoginActivity.class));
        }

        return invoke;
    }
}
