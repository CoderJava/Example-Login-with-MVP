package ysn.exampleloginmvp.views.main;

import ysn.exampleloginmvp.views.base.View;

/**
 * Created by root on 21/02/17.
 */

interface MainActivityView extends View {

    void loginInvalid(String message);

    void login();

    void loginFailed();
}
