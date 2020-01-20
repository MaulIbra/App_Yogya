package com.example.yogyakarta_app.Features.Account.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yogyakarta_app.Features.Auth.Model.Auth;
import com.example.yogyakarta_app.Features.Auth.View.AuthLoginView;
import com.example.yogyakarta_app.Features.Auth.ViewModel.AuthLogout;
import com.example.yogyakarta_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountView extends Fragment implements Auth.view {


    private TextView email;
    private Button logout;

    public AccountView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.account_view, container, false);

        logout = v.findViewById(R.id.logout);
        email = v.findViewById(R.id.email);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String em = user.getEmail();
            email.setText(em);
        }

        final AuthLogout authLogout = new AuthLogout(this);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authLogout.logout();
            }
        });

        return v;
    }

    @Override
    public void updateUI(Boolean auth) {
        if(auth) {
            startActivity(new Intent(getContext(), AuthLoginView.class));
        }
    }

    @Override
    public void showFailureMessage(String e) {

    }
}
