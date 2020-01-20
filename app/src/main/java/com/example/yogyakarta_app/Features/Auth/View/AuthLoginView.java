package com.example.yogyakarta_app.Features.Auth.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yogyakarta_app.Features.Auth.Model.Auth;
import com.example.yogyakarta_app.Features.Auth.ViewModel.AuthLogin;
import com.example.yogyakarta_app.MainActivity;
import com.example.yogyakarta_app.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class AuthLoginView extends AppCompatActivity implements Auth.view, View.OnClickListener {

    private  TextView resetPassword;
    private TextView signup;
    private EditText email;
    private EditText password;
    private Button submit;
    private Button google;
    private FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    AuthLogin authLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_login);

        mAuth = FirebaseAuth.getInstance();
        signup = findViewById(R.id.signup);
        resetPassword = findViewById(R.id.forgot);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submit);
        google = findViewById(R.id.google);

        authLogin = new AuthLogin(this);

        configurationSocialMedia();

        submit.setOnClickListener(this);
        google.setOnClickListener(this);
        resetPassword.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null){
            updateUserInterface();
        }
    }

    private void updateUserInterface() {
        Intent home = new Intent(AuthLoginView.this, MainActivity.class);
        startActivity(home);
        finish();
    }

    @Override
    public void updateUI(Boolean auth) {
        if(auth){
            Intent submit = new Intent(AuthLoginView.this, AuthLoginView.class);
            startActivity(submit);
            finish();
        }
    }

    @Override
    public void showFailureMessage() {
        Toast.makeText(this,"email or password is wrong",Toast.LENGTH_SHORT).show();
    }


    private void configurationSocialMedia(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please enter email and password",Toast.LENGTH_SHORT).show();
                }else{
                    authLogin.signInEmailPass(email.getText().toString(),password.getText().toString());
                }
                break;
            case R.id.forgot:
                startActivity(new Intent(AuthLoginView.this, AuthResetPasswordView.class));
                break;
            case R.id.google:
                signIn();
                break;

        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUserInterface();
                        } else {
                            updateUserInterface();
                        }

                    }
                });
    }
}
