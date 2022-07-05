package com.example.a3esoleaguep.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.a3esoleaguep.DB.dataBase;
import com.example.a3esoleaguep.R;
import com.example.a3esoleaguep.ui.matchResultsActivity;

public class MatchResultsDialog {
    Context context;
    dataBase mydb;
    updateTable updateTable;
    public MatchResultsDialog(Context context) {
        this.context = context;
        mydb=new dataBase(context);
        updateTable=new updateTable(context);
    }

    public void deleteMatchDialog(int id, String firstTeam, String secondTeam, int firstScore, int secondScore) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(R.string.app_name);
        alertDialog.setMessage(firstTeam + "  " + firstScore + " - " + secondScore + "  " + secondTeam + "\n\nAre you sure to delete this match?");
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "yes", (dialog, which) -> {
            mydb.deleteMatch(id);
            updateTable.update(firstTeam,secondTeam,firstScore,secondScore);
            alertDialog.dismiss();
            Intent intent = new Intent(context, matchResultsActivity.class);
            context.startActivity(intent);
            ((Activity)context).finish();
        });
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "no", (dialog, which) -> alertDialog.dismiss());
        alertDialog.show();
    }
}
