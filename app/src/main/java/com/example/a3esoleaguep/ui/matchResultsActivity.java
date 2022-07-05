package com.example.a3esoleaguep.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.a3esoleaguep.DB.dataBase;
import com.example.a3esoleaguep.R;
import com.example.a3esoleaguep.adapter.matchResultsAdapter;
import com.example.a3esoleaguep.model.match;
import com.example.a3esoleaguep.utility.MatchResultsDialog;

public class matchResultsActivity extends AppCompatActivity implements matchResultsAdapter.onUserClicked {
    TextView title;
    ImageView empty_img;
    ConstraintLayout constraintLayout;
    RecyclerView recyclerView;
    SearchView searchView;
    matchResultsAdapter adapter;
    dataBase mydb;
    MatchResultsDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_results);
        mydb = new dataBase(this);
        alertDialog=new MatchResultsDialog(this);

        title=findViewById(R.id.empty_title);
        empty_img=findViewById(R.id.empty_img);
        constraintLayout=findViewById(R.id.constraint_layout);
        recyclerView = findViewById(R.id.rv_matchResults);
        searchView = findViewById(R.id.searchView);

        searchView.setIconified(false);// to open searchView automatically
        searchView.clearFocus();


        adapter = new matchResultsAdapter(mydb.getAllMatches(), this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);

        if(adapter.getItemCount()==0)
        {
           constraintLayout.setBackgroundColor(Color.WHITE);//white background
            searchView.setVisibility(View.GONE);
            empty_img.setVisibility(View.VISIBLE);
            title.setVisibility(View.VISIBLE);
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query.trim(), getApplicationContext());
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText.trim(), getApplicationContext());
                return true;
            }
        });
    }

    @Override
    public void onUserSingleClicked(match match) {
        alertDialog.deleteMatchDialog(match.getId(), match.getFirstTeam(), match.getSecondTeam(), match.getFirstScore(), match.getSecondScore());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, tableActivity.class);
        startActivity(intent);
        finish();
    }
}