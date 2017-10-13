package com.vntechsolutions.iliked.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Bind;

import com.vntechsolutions.iliked.MainActivity;
import com.vntechsolutions.iliked.R;

/**
 * Created by chiPM on 10/12/17.
 */

public class LoginActivity extends AppCompatActivity{

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGUP = 0;

    @Bind(R.id.input_email) EditText _email_Text;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.btn_login) Button _loginButton;
    @Bind(R.id.link_signup) TextView _signupLink;

    public LoginActivity(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                login();
            }
        });
    }

    public void login(){

        if(validate()){

            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivityForResult(mainIntent, 0);
        }else{

            onLoginFailed();

            return;
        }

    }

    public void onLoginFailed(){

        Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG);
        _loginButton.setEnabled(true);
    }

    public boolean validate(){
        boolean valid = true;

        String email = _email_Text.getText().toString();
        String password = _passwordText.getText().toString();

        if(email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            _email_Text.setError(null);
        }
        if (password.isEmpty() || password.length() < 4) {
            _passwordText.setError("Mật khẩu nhập chưa đúng!");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        return valid;
    }
}
