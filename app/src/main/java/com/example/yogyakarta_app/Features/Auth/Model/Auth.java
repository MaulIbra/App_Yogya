package com.example.yogyakarta_app.Features.Auth.Model;


public interface Auth {

    interface view{
        void updateUI(Boolean auth);
        void showFailureMessage();
    }

    interface login{
        void signInEmailPass(String email, String password);
    }

    interface register{
        void createUser(String email, String password);
    }

    interface resetPassword{
        void resetPassword(String email);
    }

    interface logout{
        void logout();
    }



}
