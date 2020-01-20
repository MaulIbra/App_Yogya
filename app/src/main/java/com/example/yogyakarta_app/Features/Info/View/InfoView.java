package com.example.yogyakarta_app.Features.Info.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yogyakarta_app.Data.Db.Entity.Article;
import com.example.yogyakarta_app.Data.Db.Entity.Info;
import com.example.yogyakarta_app.Features.Article.View.ArticleAdapter;
import com.example.yogyakarta_app.Features.Article.ViewModel.ArticleViewModel;
import com.example.yogyakarta_app.Features.Info.ViewModel.InfoViewModel;
import com.example.yogyakarta_app.R;

import java.util.List;

public class InfoView extends AppCompatActivity {

    private InfoViewModel infoViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_list_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView_info);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final InfoAdapter infoAdapter = new InfoAdapter();
        recyclerView.setAdapter(infoAdapter);

        infoViewModel = ViewModelProviders.of(this).get(InfoViewModel.class);
        infoViewModel.getAllInfo().observe(this, new Observer<List<Info>>() {
            @Override
            public void onChanged(@Nullable List<Info> infos) {
                infoAdapter.setInfos(infos);
            }
        });
    }
}
