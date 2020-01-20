package com.example.yogyakarta_app;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.yogyakarta_app.Features.Account.View.AccountView;
import com.example.yogyakarta_app.Features.Home.View.HomeView;
import com.example.yogyakarta_app.Features.Info.View.InfoAddView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        changeFragment(new HomeView());
                        menuItem.setChecked(true);
                        break;
                    case R.id.addInfo:
                        startActivity(new Intent(MainActivity.this, InfoAddView.class));
                        menuItem.setChecked(true);
                        break;
                    case R.id.account:
                        changeFragment(new AccountView());
                        menuItem.setChecked(true);
                        break;
                }
                return false;
            }
        });
    }

    private void changeFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentMain, fragment);
        ft.commit();
    }

}
