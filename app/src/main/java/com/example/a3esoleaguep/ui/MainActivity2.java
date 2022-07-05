package com.example.a3esoleaguep.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a3esoleaguep.DB.dataBase;
import com.example.a3esoleaguep.R;
import com.example.a3esoleaguep.utility.check_editText_input;

public class MainActivity2 extends AppCompatActivity {
    EditText club;
    TextView clubsList , titleClubList;
    dataBase mydb;
    check_editText_input checkInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new dataBase(this);
        checkInput= new check_editText_input(this);

        if(!mydb.dataBaseIsEmpty())
        {
            Intent intent=new Intent(MainActivity2.this, tableActivity.class);
            startActivity(intent);
            finish();
        }

        club=findViewById(R.id.clubET_main);
        clubsList=findViewById(R.id.clubsList);
        titleClubList=findViewById(R.id.titleClubList);

        findViewById(R.id.btn_add).setOnClickListener(v -> {
            if(!checkInput.validInputs(club))return;

            titleClubList.setVisibility(View.VISIBLE);
            clubsList.setVisibility(View.VISIBLE);

            mydb.insertData(club.getText().toString().trim());
            clubsList.setText(clubsList.getText().toString().trim()+"  "+club.getText().toString().trim());
            club.setText("");
        });
        findViewById(R.id.btn_done).setOnClickListener(v -> {
            if(!checkInput.isEnoughClubs())return;

            Intent intent=new Intent(MainActivity2.this,tableActivity.class);
            startActivity(intent);
        });

    }

}