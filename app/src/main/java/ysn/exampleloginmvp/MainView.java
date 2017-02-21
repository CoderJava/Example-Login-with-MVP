package ysn.exampleloginmvp;

/**
 * Created by root on 21/02/17.
 */

public interface MainView extends View {

    void onValidationError(String message);

    void onLogin(String username, String password);

    void onLoginSuccess();

    void onLoginFail();
}
