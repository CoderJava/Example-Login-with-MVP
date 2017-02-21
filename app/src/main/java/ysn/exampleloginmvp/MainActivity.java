package ysn.exampleloginmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onDestroy() {
        mainPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        onAttach();
        loadComponent();
    }

    private void loadComponent() {
        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        buttonLogin = (Button) findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                mainPresenter.onLogin(username, password);
            }
        });
    }

    private void initPresenter() {
        mainPresenter = new MainPresenter();
    }

    @Override
    public void onValidationError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onLogin(String username, String password) {
        if (username.isEmpty()) {
            mainPresenter.onValidationError("Username masih kosong");
        } else if (password.isEmpty()) {
            mainPresenter.onValidationError("Password masih kosong");
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                mainPresenter.onLoginSuccess();
            } else {
                mainPresenter.onLoginFail();
            }
        }
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "Login success", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onAttach() {
        mainPresenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        mainPresenter.onDetach();
    }
}
