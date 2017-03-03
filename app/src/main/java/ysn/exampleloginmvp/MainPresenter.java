package ysn.exampleloginmvp;

import android.text.TextUtils;

/**
 * Created by root on 21/02/17.
 */

public class MainPresenter implements Presenter<MainView> {

    private MainView mainView;

    @Override
    public void onAttach(MainView view) {
        mainView = view;
    }

    @Override
    public void onDetach() {
        mainView = null;
    }

    public void onLogin(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            mainView.onValidationError("Username is empty!");
        } else if (TextUtils.isEmpty(password)) {
            mainView.onValidationError("Password is empty!");
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                mainView.onLoginSuccess();
            } else {
                mainView.onLoginFail();
            }
        }
    }

}
