package com.example.yogyakarta_app.Features.Info.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yogyakarta_app.Data.Db.Entity.Info;
import com.example.yogyakarta_app.Features.Info.ViewModel.InfoViewModel;
import com.example.yogyakarta_app.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoAddView extends AppCompatActivity {

    private EditText content,name;
    private Button save;
    private InfoViewModel infoViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_add);

        content = findViewById(R.id.edit_text_info_content);
        name = findViewById(R.id.edit_text_info_name);
        save = findViewById(R.id.button_info_save);

        infoViewModel = ViewModelProviders.of(this).get(InfoViewModel.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = name.getText().toString();
                String contents = content.getText().toString();
                saveInfo(names,contents);
            }
        });

    }

    private void saveInfo(String names, String contents){
        String tanggal = currentDate();

        if (names.trim().isEmpty() || contents.trim().isEmpty()){
            Toast.makeText(this,"please insert name and what can you say",Toast.LENGTH_SHORT).show();
            return;
        }
        Info i = new Info(contents,tanggal,names);
        System.out.println("tanggal"+tanggal);
        System.out.println("contentnya"+contents);
        System.out.println("name"+names);
        infoViewModel.insert(i);
        startActivity(new Intent(InfoAddView.this,InfoView.class));
    }

    public String currentDate(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        Date dateobj = new Date();
        return String.valueOf(df.format(dateobj));
    }
}

