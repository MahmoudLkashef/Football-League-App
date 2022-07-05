package com.example.a3esoleaguep.utility;

import android.content.Context;

import com.example.a3esoleaguep.DB.dataBase;

public class updateDatabase {
    Context context;
    dataBase mydb;

    public updateDatabase(Context context) {
        this.context = context;
        mydb = new dataBase(context);
    }

    public void updateData(String winner, int winnerResult, String loser, int loserResult) {
        if (winnerResult == loserResult) { //draw case
            mydb.updatedDrawData(winner, winnerResult, loserResult);
            mydb.updatedDrawData(loser, loserResult, winnerResult);
            return;
        }
        mydb.updateWinnerData(winner, winnerResult, loserResult);
        mydb.updateLoserData(loser, loserResult, winnerResult);
    }
}
