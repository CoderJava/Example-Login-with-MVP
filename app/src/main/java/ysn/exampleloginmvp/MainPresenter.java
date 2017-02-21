package ysn.exampleloginmvp;

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

    public void onValidationError(String message) {
        mainView.onValidationError(message);
    }

    public void onLogin(String username, String password) {
        mainView.onLogin(username, password);
    }

    public void onLoginSuccess() {
        mainView.onLoginSuccess();
    }

    public void onLoginFail() {
        mainView.onLoginFail();
    }

}
