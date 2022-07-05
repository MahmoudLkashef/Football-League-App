package com.example.a3esoleaguep.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3esoleaguep.R;

public class clubViewHolder extends RecyclerView.ViewHolder {
    TextView club , GP , points, win, draw,lose,GI,GO;

    public clubViewHolder(@NonNull View itemView) {
        super(itemView);
        club=itemView.findViewById(R.id.CLUB_TV);
        GP=itemView.findViewById(R.id.GP_TV);
        points=itemView.findViewById(R.id.points_TV);
        win=itemView.findViewById(R.id.win_TV);
        lose=itemView.findViewById(R.id.lose_TV);
        draw=itemView.findViewById(R.id.draw_TV);
        GI=itemView.findViewById(R.id.GI_TV);
        GO=itemView.findViewById(R.id.GO_TV);

    }
}
