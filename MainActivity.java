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
     * ��ʼ������
     */
    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_logon = (Button) findViewById(R.id.btn_login);
        btn_logon.setOnClickListener(this);
        loginPresenter = new LoginPresenter();

        loginPresenter.bind(this);//��View��Presenter����Ϊ���Activity�Ѿ�ʵ���˽ӿڣ��Ѿ�������View����
    }

    /**
     * ��¼��ť�ļ�������
     * ����Ҫ����̨���ݵĴ�����Ҫ�õ�Presenter
     */
    @Override
    public void onClick(View v) {
        loginPresenter.login();
    }

    /**
     * ���������������ʵ��LoginView��Ҫ��ʵ�ֵķ���
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
        //��¼�ɹ���һ����ʵ��ҳ�����ת
        Toast.makeText(this, "��¼�ɹ�", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showNetworkError() {
        Toast.makeText(this, "��ǰ���粻����", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showVerifyFailed() {
        Toast.makeText(this, "������û�������������", Toast.LENGTH_SHORT).show();
    }


}