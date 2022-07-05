package com.example.a3esoleaguep.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3esoleaguep.DB.dataBase;
import com.example.a3esoleaguep.R;
import com.example.a3esoleaguep.model.match;

import java.util.ArrayList;

public class matchResultsAdapter extends RecyclerView.Adapter<matchResultsAdapter.dataViewHolder> {
ArrayList<match>data;
onUserClicked onUserClicked;
public interface onUserClicked
{
    public void onUserSingleClicked(match match);
}
    public matchResultsAdapter(ArrayList<match> data, onUserClicked onUserClicked) {
        this.data = data;
        this.onUserClicked=onUserClicked;

    }
/*    public void register(onUserClicked onUserClicked)
    {
        this.onUserClicked=onUserClicked;
    }*/

    @NonNull
    @Override
    public dataViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.match_items,parent,false);
        dataViewHolder viewHolder=new dataViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  matchResultsAdapter.dataViewHolder holder, int position) {
        match d=data.get(position);
        holder.team1.setText(d.getFirstTeam());
        holder.team2.setText(d.getSecondTeam());
        holder.score1.setText(String.valueOf(d.getFirstScore()));
        holder.score2.setText(String.valueOf(d.getSecondScore()));
        holder.deleteMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUserClicked.onUserSingleClicked(d);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class dataViewHolder extends RecyclerView.ViewHolder
    {
        TextView team1,team2,score1,score2;
        ImageView deleteMatch;
        public dataViewHolder(@NonNull  View itemView) {
            super(itemView);
            team1=itemView.findViewById(R.id.team1_display);
            team2=itemView.findViewById(R.id.team2_display);
            score1=itemView.findViewById(R.id.score1_display);
            score2=itemView.findViewById(R.id.score2_display);
            deleteMatch=itemView.findViewById(R.id.deleteMatch);
        }
    }
        public void filter(String text,Context context) {
            dataBase mydb=new dataBase(context);
            data.clear();
            if(text.isEmpty()){
                data.addAll(mydb.getAllMatches());
            } else{
                text = text.toLowerCase();
                for(match item: mydb.getAllMatches()){
                    if(item.getFirstTeam().toLowerCase().contains(text) || item.getSecondTeam().toLowerCase().contains(text)){
                        data.add(item);
                    }
                }
            }
            notifyDataSetChanged();
        }

}
