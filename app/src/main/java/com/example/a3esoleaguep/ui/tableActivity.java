package com.example.a3esoleaguep.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a3esoleaguep.DB.dataBase;
import com.example.a3esoleaguep.adapter.TableAdapter;
import com.example.a3esoleaguep.R;
import com.example.a3esoleaguep.utility.TableAlertDialogs;

public class tableActivity extends AppCompatActivity {
    Button setMatch, repeatLeague, deleteTable, matchResults;
    RecyclerView recyclerView;
    TableAdapter adapter;
    dataBase mydb;
    TableAlertDialogs alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        mydb = new dataBase(this);
        alertDialog=new TableAlertDialogs(this);

        setMatch = findViewById(R.id.setMatch_btn);
        repeatLeague = findViewById(R.id.repeat_btn);
        deleteTable = findViewById(R.id.deleteTable_btn);
        matchResults = findViewById(R.id.matchResult_btn);

        recyclerView = findViewById(R.id.rv);


        adapter=new TableAdapter(mydb.sortData());
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(lm);

        setMatch.setOnClickListener(v -> {
            Intent intent = new Intent(tableActivity.this,setMatch.class);
            startActivity(intent);
            finish();
        });

        repeatLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.repeatAlertDialog();
            }
        });

        deleteTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.deleteAlertDialog();
            }
        });

        matchResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tableActivity.this, matchResultsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}