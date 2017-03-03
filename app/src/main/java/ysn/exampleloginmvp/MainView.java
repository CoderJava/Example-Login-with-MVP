package ysn.exampleloginmvp;

/**
 * Created by root on 21/02/17.
 */

public interface MainView extends View {

    void onValidationError(String message);

    void onLoginSuccess();

    void onLoginFail();
}
