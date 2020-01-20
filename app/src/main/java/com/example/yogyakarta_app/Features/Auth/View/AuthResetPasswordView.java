package com.example.yogyakarta_app.Features.Auth.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yogyakarta_app.Features.Auth.Model.Auth;
import com.example.yogyakarta_app.Features.Auth.ViewModel.AuthResetPassword;
import com.example.yogyakarta_app.R;

public class AuthResetPasswordView extends AppCompatActivity implements Auth.view {

    private ImageView back;
    private EditText email;
    private Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_forgotpass);
        final AuthResetPassword authResetPassword = new AuthResetPassword(this);

        email = findViewById(R.id.email);
        submit = findViewById(R.id.submit);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AuthResetPasswordView.this,AuthLoginView.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please enter email ",Toast.LENGTH_SHORT).show();
                }else{
                    authResetPassword.resetPassword(email.getText().toString());
                }
            }
        });
    }

    @Override
    public void updateUI(Boolean auth) {
        if(auth){
            startActivity(new Intent(AuthResetPasswordView.this,AuthLoginView.class));
        }
    }

    @Override
    public void showFailureMessage(String e) {
        Toast.makeText(this,e,Toast.LENGTH_SHORT).show();
    }
}
