package com.example.mvptest;

/**
 * mvp�е�View�Ķ���
 * �û���¼�����û��Ĳ�����Ϊ�Ķ���
 */
public interface LoginView {


    String getAccount();//��ȡ�û����˺ţ������˺�

    String getPassword();//��ȡ�û���Ī�꣬��������

    void loginSuccess(User user);//��¼��ʵ�֣���Ҫ�����û�����

    void showNetworkError();//��ʾ�����쳣

    void showVerifyFailed();//��Ϣ��֤ʧ��,�˺Ż���������
}