package com.example.a3esoleaguep.utility;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;


public class find_winner_loser {
     private String winner , loser;
    private int winnerResult , loserResult;

    public void calc_winner_loser(EditText firstClubET, EditText firstScoreET, EditText secondClubET, EditText secondScoreET )
    {

        if( (Integer.parseInt(firstScoreET.getText().toString().trim())) > (Integer.parseInt(secondScoreET.getText().toString().trim())) ) //FirstClub win
        {
            winner= firstClubET.getText().toString().trim();
            loser= secondClubET.getText().toString().trim();
            winnerResult =Integer.parseInt(firstScoreET.getText().toString().trim());
            loserResult =Integer.parseInt(secondScoreET.getText().toString().trim());
        }
        else if( (Integer.parseInt(firstScoreET.getText().toString().trim())) < (Integer.parseInt(secondScoreET.getText().toString().trim())) ) //SecondClub win
        {
            winner= secondClubET.getText().toString().trim();
            loser= firstClubET.getText().toString().trim();
            winnerResult =Integer.parseInt(secondScoreET.getText().toString().trim());
            loserResult =Integer.parseInt(firstScoreET.getText().toString().trim());
        }
        else //draw
        {
            winner= firstClubET.getText().toString().trim();
            loser= secondClubET.getText().toString().trim();
            winnerResult = loserResult =Integer.parseInt(firstScoreET.getText().toString().trim());
        }
    }
    public String getWinner(){
        return winner;
    }
    public String getLoser()
    {
        return loser;
    }
    public int getWinnerResult(){
        return winnerResult;
    }
    public int getLoserResult(){
        return loserResult;
    }

}
