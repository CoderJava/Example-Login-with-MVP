package ysn.exampleloginmvp.views.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ysn.exampleloginmvp.R;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private final String TAG = getClass().getSimpleName();
    private MainActivityPresenter mainActivityPresenter;

    @BindView(R.id.edit_text_username_activity_main)
    EditText editTextUsernameActivityMain;
    @BindView(R.id.edit_text_password_activity_main)
    EditText editTextPasswordActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); // don't forget it when use ButterKnife
        initPresenter();
    }

    private void initPresenter() {
        mainActivityPresenter = new MainActivityPresenter();
    }

    @OnClick({
            R.id.button_login_activity_main,
            R.id.button_cancel_activity_main
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login_activity_main:
                // todo: do something on login
                String username = editTextUsernameActivityMain.getText().toString().trim();
                String password = editTextPasswordActivityMain.getText().toString().trim();
                mainActivityPresenter.onLogin(username, password);
                break;
            case R.id.button_cancel_activity_main:
                // todo: do something on cancel
                editTextUsernameActivityMain.setText("");
                editTextPasswordActivityMain.setText("");
                break;
        }
    }

    @Override
    protected void onResume() {
        onAttachView();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    @Override
    public void onAttachView() {
        mainActivityPresenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        mainActivityPresenter.onDetach();
    }

    @Override
    public void loginInvalid(String message) {
        // todo: login invalid
        Toast.makeText(this, message, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void login() {
        // todo: login success
        Toast.makeText(this, "Login success", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void loginFailed() {
        // todo: login failed
        Toast.makeText(this, "Login failed", Toast.LENGTH_LONG)
                .show();
    }
}
