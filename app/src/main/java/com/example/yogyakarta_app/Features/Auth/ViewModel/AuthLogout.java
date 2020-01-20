package com.example.yogyakarta_app.Features.Auth.ViewModel;

import com.example.yogyakarta_app.Features.Auth.Model.Auth;
import com.google.firebase.auth.FirebaseAuth;

public class AuthLogout implements Auth.logout {

    FirebaseAuth mAuth;
    private Auth.view authView;

    public AuthLogout(Auth.view authView) {
        this.authView = authView;
    }

    @Override
    public void logout() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        authView.updateUI(true);
    }
}
