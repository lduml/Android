package com.example.mvptest;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity implements LoginView, View.OnClickListener {

	private EditText et_name;
    private EditText et_password;
    private Button btn_logon;

    private LoginPresenter loginPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化数据
     */
    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_logon = (Button) findViewById(R.id.btn_login);
        btn_logon.setOnClickListener(this);
        loginPresenter = new LoginPresenter();

        loginPresenter.bind(this);//绑定View和Presenter，因为这个Activity已经实现了接口，已经包含了View对象
    }

    /**
     * 登录按钮的监听方法
     * 这里要做后台数据的处理，需要用到Presenter
     */
    @Override
    public void onClick(View v) {
        loginPresenter.login();
    }

    /**
     * 下面五个方法都是实现LoginView后要是实现的方法
     */

    @Override
    public String getAccount() {
        return et_name.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString();
    }

    @Override
    public void loginSuccess(User user) {
        //登录成功后，一般是实现页面的跳转
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showNetworkError() {
        Toast.makeText(this, "当前网络不可用", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showVerifyFailed() {
        Toast.makeText(this, "输入的用户名或密码有误", Toast.LENGTH_SHORT).show();
    }


}