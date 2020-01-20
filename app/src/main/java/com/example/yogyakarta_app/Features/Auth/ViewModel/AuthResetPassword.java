package com.example.yogyakarta_app.Features.Auth.ViewModel;

import android.support.annotation.NonNull;

import com.example.yogyakarta_app.Features.Auth.Model.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class AuthResetPassword implements Auth.resetPassword {

    FirebaseAuth mAuth;
    private Auth.view authView;

    public AuthResetPassword(Auth.view authView) {
        this.authView = authView;
    }

    @Override
    public void resetPassword(String email) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    authView.updateUI(true);
                }
                else{
                    authView.updateUI(false);
                }
            }
        });
    }
}
