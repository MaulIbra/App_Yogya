package com.example.yogyakarta_app.Features.Tour.View;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yogyakarta_app.Data.Db.Entity.Tour;
import com.example.yogyakarta_app.Utils.Map.Map;
import com.example.yogyakarta_app.R;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourHolder> {

    private Context context;
    private List<Tour> tourList;

    public TourAdapter(Context context, List<Tour> tourList) {
        this.context = context;
        this.tourList = tourList;
    }

    @NonNull
    @Override
    public TourHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tour_item,viewGroup,false);
        return new TourHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final TourHolder tourHolder, int i) {
        final Tour currentTour = tourList.get(i);
        tourHolder.title.setText(currentTour.getTitle());
        tourHolder.address.setText(currentTour.getAddress());
        Glide.with(context)
                .load(currentTour.getImageUrl())
                .apply(new RequestOptions().centerCrop())
                .into(tourHolder.tourImage);

        tourHolder.tourLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Map.class);
                i.putExtra("title",currentTour.getTitle());
                i.putExtra("latitude",currentTour.getLatitude());
                i.putExtra("longitude",currentTour.getLongitude());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    public void setTour(List<Tour> tour){
        this.tourList = tour;
        notifyDataSetChanged();
    }

    class TourHolder extends RecyclerView.ViewHolder{

        private ImageView tourImage;
        private ImageView tourLocation;
        private TextView title;
        private TextView address;

        public TourHolder(@NonNull View itemView) {
            super(itemView);
            tourImage = itemView.findViewById(R.id.image_view_tour_image);
            tourLocation = itemView.findViewById(R.id.tourLocation);
            title = itemView.findViewById(R.id.tourTitle);
            address = itemView.findViewById(R.id.tourAddress);
        }
    }
}
