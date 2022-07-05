package com.example.a3esoleaguep.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.a3esoleaguep.DB.dataBase;
import com.example.a3esoleaguep.R;
import com.example.a3esoleaguep.utility.check_editText_input;
import com.example.a3esoleaguep.utility.find_winner_loser;
import com.example.a3esoleaguep.utility.updateDatabase;

public class setMatch extends AppCompatActivity {
    EditText firstClubET, secondClubET, firstScoreET, secondScoreET;
    String winner, loser;
    int winnerResult, loserResult;
    check_editText_input checkInput;
    find_winner_loser findWinnerLoser;
    updateDatabase updateDatabase;
    dataBase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setmatch);
        mydb=new dataBase(this);
        checkInput = new check_editText_input(this);
        findWinnerLoser = new find_winner_loser();
        updateDatabase=new updateDatabase(this);

        findViewById(R.id.btn_done_setmatch).setOnClickListener(v -> {
            firstClubET = (EditText) findViewById(R.id.firstClub_new);
            secondClubET = (EditText) findViewById(R.id.secondClub_new);
            firstScoreET = (EditText) findViewById(R.id.score1_new);
            secondScoreET = (EditText) findViewById(R.id.score2_new);

            if (!checkInput.validInputs(firstClubET, firstScoreET, secondClubET, secondScoreET))
                return;

            findWinnerLoser.calc_winner_loser(firstClubET, firstScoreET, secondClubET, secondScoreET);

            winner = findWinnerLoser.getWinner();
            loser = findWinnerLoser.getLoser();
            winnerResult = findWinnerLoser.getWinnerResult();
            loserResult = findWinnerLoser.getLoserResult();

            updateDatabase.updateData(winner, winnerResult, loser, loserResult);
            mydb.insertData(winner,loser,winnerResult,loserResult);

            Intent intent = new Intent(this, tableActivity.class);
            startActivity(intent);
            finish();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this,tableActivity.class);
        startActivity(intent);
        finish();
    }
}