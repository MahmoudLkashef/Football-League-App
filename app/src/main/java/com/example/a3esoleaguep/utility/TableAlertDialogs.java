package com.example.a3esoleaguep.utility;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.example.a3esoleaguep.DB.dataBase;
import com.example.a3esoleaguep.ui.tableActivity;
import com.example.a3esoleaguep.ui.MainActivity2;
import com.example.a3esoleaguep.R;

public class TableAlertDialogs {
    Context context;
    dataBase mydb;

    public TableAlertDialogs(Context context) {
        this.context = context;
        mydb=new dataBase(context);
    }

    public void deleteAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(R.string.app_name);
        alertDialog.setMessage("Are you sure to delete all data?");
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "yes", (dialog, which) -> {
            mydb.deleteData();
            alertDialog.dismiss();
            Intent intent = new Intent(context, MainActivity2.class);
            context.startActivity(intent);
            ((Activity)context).finish();
        });
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "no", (dialog, which) -> alertDialog.dismiss());
        alertDialog.show();
    }

    public void repeatAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(R.string.app_name);
        alertDialog.setMessage("Do you want to repeat league with the same teams?");
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "yes", (dialog, which) -> {
            mydb.repeatLeague();
            alertDialog.dismiss();
            Intent intent = new Intent(context, tableActivity.class);
            context.startActivity(intent);
            ((Activity)context).finish();
        });
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "no", (dialog, which) -> alertDialog.dismiss());
        alertDialog.show();
    }
}
