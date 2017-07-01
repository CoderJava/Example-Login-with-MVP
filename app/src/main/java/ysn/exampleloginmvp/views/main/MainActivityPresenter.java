package ysn.exampleloginmvp.views.main;

import android.text.TextUtils;

import ysn.exampleloginmvp.views.base.Presenter;

/**
 * Created by root on 21/02/17.
 */

class MainActivityPresenter implements Presenter<MainActivityView> {

    private MainActivityView mainActivityView;

    @Override
    public void onAttach(MainActivityView view) {
        mainActivityView = view;
    }

    @Override
    public void onDetach() {
        mainActivityView = null;
    }

    void onLogin(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            mainActivityView.loginInvalid("Username is empty!");
        } else if (TextUtils.isEmpty(password)) {
            mainActivityView.loginInvalid("Password is empty!");
        } else if (username.equals("admin") && password.equals("admin")){
            mainActivityView.login();
        }  else {
            mainActivityView.loginFailed();
        }
    }
}
