package com.example.yogyakarta_app.Features.Auth.ViewModel;

import android.support.annotation.NonNull;

import com.example.yogyakarta_app.Features.Auth.Model.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.concurrent.Executor;

public class AuthLogin implements Auth.login {

    FirebaseAuth mAuth;
    private Auth.view authView;

    public AuthLogin(Auth.view authView) {
        this.authView = authView;
    }

    @Override
    public void signInEmailPass(String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            authView.updateUI(true);
                        }else{
                            authView.showFailureMessage();
                            authView.updateUI(false);
                        }
                    }
                });
    }
}
