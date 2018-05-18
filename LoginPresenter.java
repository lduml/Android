package com.example.mvptest;

import android.text.TextUtils;
import android.util.Log;

/**
 * mvp��Presenter�е����
 * Ҳ�ǱȽ��ѣ���Ҫ�ص�����һ��
 * presenter�������˵���˼��view��model���м���
 * ��ҪͬʱҪ��View�Ķ����Model�Ķ���һ�������ǣ��ڹ��췽���д���model���󣬲�����һ��������View�ӿ�
 * ������Է������ݴ��������߼��ж�����Ǹ�mvp�е�View�������������ģ�
 */
public class LoginPresenter {

    /**
     * ��¼ҵ��ʵ���ߣ����ݴ���Ĳ�����
     */
    private LoginModel mLoginModel;

    /**
     * �ڹ��췽����ʵ����model����
     */
    public LoginPresenter() {
        mLoginModel = new LoginModel();

    }


    //��ͼ�ӿڶ���
    private LoginView mLoginView;

    /**
     * ��View �ķ���
     *
     * @param loginView
     */
    public void bind(MainActivity loginView) {
        mLoginView = loginView;
    }

    /**
     * ��¼ҵ��
     */
    public void login() {
        String account = mLoginView.getAccount();
        String password = mLoginView.getPassword();
        Log.e("TAG", "account:" + account + ",password" + password);
        if (checkParameter(account, password)) {
            doSomePrepare();
            //��¼ ����Ҫ�������ݣ�����Ҫ��model��ִ��
            mLoginModel.login(account, password, new LoginModel.OnLoginResultListener() {
                //��¼�ɹ��Ļص�����
                @Override
                public void loginSuccess(User user) {
                    mLoginView.loginSuccess(user);   //�ڸ���ͼҳ�淵��User����
                }

                //��¼ʧ�ܵĻص�����
                @Override
                public void loginFailure() {
                    mLoginView.showVerifyFailed();//�ڸ���ͼҳ�淵����֤ʧ�ܵĽ��
                }
            });


        }
    }


    /**
     * ��һЩ׼��
     */
    private void doSomePrepare() {
        //����������ð�ť���ɵ��������һֱ�����¼Ҳ�ǲ���
    }

    /**
     * �������Ƿ��Ƿ�Ϊ��~~~
     *
     * @param account
     * @param password
     * @return
     */
    private boolean checkParameter(String account, String password) {
        if (TextUtils.isEmpty(account) | TextUtils.isEmpty(password)) {
            mLoginView.showVerifyFailed();//��ʾ����
            return false;
        } else if (!checkNetwork()) {
            mLoginView.showNetworkError();//��ʾ�������
            return false;
        }
        return true;
    }

    /**
     * ��������Ƿ����
     */
    public boolean checkNetwork() {
        return true;//����ʾ����������ʵ����Ҫ�ô����ж�
    }


}