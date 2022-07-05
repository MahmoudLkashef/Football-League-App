package com.example.a3esoleaguep.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3esoleaguep.R;
import com.example.a3esoleaguep.model.Club;

import java.util.ArrayList;

public class TableAdapter extends RecyclerView.Adapter<clubViewHolder> {
    ArrayList<Club> clubData;

    public TableAdapter(ArrayList<Club> clubData) {
        this.clubData = clubData;
    }

    @NonNull
    @Override
    public clubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_items, null, false);
        clubViewHolder VH = new clubViewHolder(view);
        return VH;
    }

    @Override
    public void onBindViewHolder(@NonNull clubViewHolder holder, int position) {
        Club club = clubData.get(position);
        holder.club.setText(club.getClub());
        holder.GP.setText(String.valueOf(club.getGP()));
        holder.points.setText(String.valueOf(club.getPoints()));
        holder.win.setText(String.valueOf(club.getWin()));
        holder.draw.setText(String.valueOf(club.getDraw()));
        holder.lose.setText(String.valueOf(club.getLose()));
        holder.GI.setText(String.valueOf(club.getGI()));
        holder.GO.setText(String.valueOf(club.getGO()));
    }

    @Override
    public int getItemCount() {
        return clubData.size();
    }
}
