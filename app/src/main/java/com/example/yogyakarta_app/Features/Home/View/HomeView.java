package com.example.yogyakarta_app.Features.Home.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.yogyakarta_app.Features.Article.View.ArticleView;
import com.example.yogyakarta_app.Features.Info.View.InfoView;
import com.example.yogyakarta_app.Features.News.View.NewsView;
import com.example.yogyakarta_app.Features.Tour.View.TourView;
import com.example.yogyakarta_app.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class HomeView extends Fragment implements View.OnClickListener {

    private LinearLayout mLinearLayout;
    private LinearLayout news,tour,info,article;
    SliderLayout sliderLayout;

    public HomeView() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home_view, container, false);

        news = v.findViewById(R.id.image_view_home_news);
        news.setOnClickListener(this);

        tour = v.findViewById(R.id.image_view_home_tour);
        tour.setOnClickListener(this);

        info = v.findViewById(R.id.image_view_home_info);
        info.setOnClickListener(this);

        article = v.findViewById(R.id.image_view_home_article);
        article.setOnClickListener(this);

        sliderLayout = v.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();

        return v;
    }

    @Override
    public void onClick(View v) {
        LinearLayout b = (LinearLayout) v;
        switch(b.getId()) {
            case R.id.image_view_home_news:
                startActivity(new Intent(getActivity(),NewsView.class));
                break;
            case R.id.image_view_home_tour:
                startActivity(new Intent(getActivity(), TourView.class));
                break;
            case R.id.image_view_home_info:
                startActivity(new Intent(getActivity(), InfoView.class));
                break;
            case R.id.image_view_home_article:
                startActivity(new Intent(getActivity(), ArticleView.class));
                break;
        }
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(getActivity());

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://img.jakpost.net/c/2019/03/13/2019_03_13_67532_1552463717._large.jpg");
                    break;
                case 1:
                    sliderView.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/f/f0/Malioboro_Street%2C_Yogyakarta.JPG");
                    break;
                case 2:
                    sliderView.setImageUrl("https://img.okeinfo.net/content/2019/06/27/406/2071815/5-spot-berburu-sunrise-di-yogyakarta-mana-yang-paling-cantik-versi-kamu-qiEl2rE2pV.jpg");
                    break;
                case 3:
                    sliderView.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrUUbUqqsnM8jwCQf0zcqj2cmA6V02cYgWhxIyIrDiizPi2siC&s");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getActivity(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });
            sliderLayout.addSliderView(sliderView);
        }
    }

}
