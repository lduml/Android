package com.example.mvptest;

/**
 * MVP�е�model���ݴ�����
 * ���ﴦ���¼ʱ������
 */
public class LoginModel {

    /**
     * �����¼ҵ�񲢷��ؽ��
     */
    public void login(String name,String password,OnLoginResultListener onLoginResultListener){
        //һ���¼�����������������֤
        //����ͼ�һ�㣬��ұ����
        if ("liwen".equals(name)&&"123456".equals(password)){
            onLoginResultListener.loginSuccess(new User(name,password));//��¼�ɹ�,���������û�����
        }else {
            onLoginResultListener.loginFailure();//��¼ʧ��
        }

    }


    //�ص��ӿ�
    public interface OnLoginResultListener {

        void loginSuccess(User user);//��¼�ɹ���ص��ķ���������User����

        void loginFailure();//��¼ʧ�ܺ�ص��ķ���

    }
    
}