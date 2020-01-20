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
import android.widget.Toast;

import com.example.yogyakarta_app.Features.Auth.Model.Auth;
import com.example.yogyakarta_app.Features.Auth.ViewModel.AuthRegister;
import com.example.yogyakarta_app.R;
import com.google.firebase.auth.FirebaseAuth;

public class AuthRegisterView extends AppCompatActivity implements Auth.view {

    private ImageView back;
    private EditText email;
    private EditText password;
    private Button submit;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_register);

        mAuth = FirebaseAuth.getInstance();
        final AuthRegister authRegister = new AuthRegister(this);
        back = findViewById(R.id.back);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submit);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AuthRegisterView.this, AuthLoginView.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString();
                String pass = password.getText().toString();
                if (TextUtils.isEmpty(em) || TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(),"Please enter email and password",Toast.LENGTH_SHORT).show();
                }else{
                    authRegister.createUser(em,pass);
                }
            }
        });
    }

    @Override
    public void updateUI(Boolean auth) {
        if(auth){
            Intent home = new Intent(AuthRegisterView.this, AuthLoginView.class);
            startActivity(home);
            finish();
        }
    }

    @Override
    public void showFailureMessage() {
        Toast.makeText(this,"email or password is wrong",Toast.LENGTH_SHORT).show();
    }
}
