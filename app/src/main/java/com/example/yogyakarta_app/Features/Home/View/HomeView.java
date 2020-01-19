package com.example.yogyakarta_app.Features.Home.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.yogyakarta_app.Features.News.View.NewsView;
import com.example.yogyakarta_app.R;

public class HomeView extends Fragment implements View.OnClickListener {


    private LinearLayout news,eat,hotel,tour,info,article;

    public HomeView() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home_view, container, false);

        news = v.findViewById(R.id.image_view_home_news);
        news.setOnClickListener(this);

        eat = v.findViewById(R.id.image_view_home_eat);
        hotel = v.findViewById(R.id.image_view_home_hotel);
        tour = v.findViewById(R.id.image_view_home_tour);
        info = v.findViewById(R.id.image_view_home_info);
        article = v.findViewById(R.id.image_view_home_article);

        return v;
    }

    @Override
    public void onClick(View v) {
        LinearLayout b = (LinearLayout) v;
        switch(b.getId()) {
            case R.id.image_view_home_news:
                startActivity(new Intent(getActivity(),NewsView.class));
                break;
        }
    }
}
