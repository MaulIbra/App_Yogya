package com.example.yogyakarta_app.Features.Auth.ViewModel;

import android.support.annotation.NonNull;

import com.example.yogyakarta_app.Features.Auth.Model.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthRegister implements Auth.register {

    FirebaseAuth mAuth;
    private Auth.view authView;

    public AuthRegister(Auth.view authView) {
        this.authView = authView;
    }

    @Override
    public void createUser(String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            authView.updateUI(true);
                        } else {
                            authView.updateUI(false);
                        }
                    }
                });
    }
}
