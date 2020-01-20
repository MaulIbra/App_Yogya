package com.example.yogyakarta_app.Features.Info.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yogyakarta_app.Data.Db.Entity.Info;
import com.example.yogyakarta_app.R;

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoHolder> {

    private List<Info> infos = new ArrayList<>();

    @NonNull
    @Override
    public InfoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.info_item,viewGroup,false);
        return new InfoHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoHolder infoHolder, int i) {
        Info currentInfo = infos.get(i);
        infoHolder.nameInfo.setText(currentInfo.getName());
        infoHolder.timeInfo.setText(currentInfo.getTimeInfo());
        infoHolder.contentInfo.setText(currentInfo.getContentInfo());
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    public void setInfos(List<Info> infos){
        this.infos = infos;
        notifyDataSetChanged();
    }

    class InfoHolder extends RecyclerView.ViewHolder{

        private TextView nameInfo;
        private TextView timeInfo;
        private TextView contentInfo;

        public InfoHolder(@NonNull View itemView) {
            super(itemView);
            nameInfo = itemView.findViewById(R.id.text_view_info_name);
            timeInfo = itemView.findViewById(R.id.text_view_info_time);
            contentInfo = itemView.findViewById(R.id.text_view_info_content);
        }
    }
}
