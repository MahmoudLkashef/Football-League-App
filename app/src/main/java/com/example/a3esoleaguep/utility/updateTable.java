package com.example.a3esoleaguep.utility;

import android.content.Context;

import com.example.a3esoleaguep.DB.dataBase;

public class updateTable {
    Context context;
    dataBase mydb;

    public updateTable(Context context) {
        this.context = context;
        mydb=new dataBase(context);
    }

    public void update(String firstTeam, String secondTeam, int firstScore, int secondScore)
    {
        if(firstScore==secondScore)
        {
            mydb.updateAfterDeleteDrawMatch(firstTeam,firstScore,secondScore);
            mydb.updateAfterDeleteDrawMatch(secondTeam,secondScore,firstScore);
            return;
        }
        mydb.updateAfterDeleteWinMatch(firstTeam,firstScore,secondScore);
        mydb.updateAfterDeleteLoseMatch(secondTeam,secondScore,firstScore);
    }
}
