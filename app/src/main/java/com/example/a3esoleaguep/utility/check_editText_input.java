package com.example.a3esoleaguep.utility;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a3esoleaguep.DB.dataBase;

public class check_editText_input {
    Context context;
    dataBase mydb;

    public check_editText_input(Context context) {
        this.context=context;

        mydb=new dataBase(context);
    }
    public boolean isEmpty(EditText editText)
    {
        if((editText.getText().toString().trim()).equals(""))return true;
        return false;
    }
    public boolean isClubExists(EditText clubET)
    {
        return mydb.isClubExists(clubET.getText().toString().trim());
    }
    public boolean isClubDuplicated(EditText firstClubET,EditText secondClubET)
    {
        if((firstClubET.getText().toString().trim()).equalsIgnoreCase(secondClubET.getText().toString().trim()))return true;
        return false;
    }
    public boolean isEnoughClubs()
    {
        if((mydb.getAllData().size())>=2)return true;
        else {
            Toast.makeText(context, "Enter enough clubs", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean validClub(EditText firstClubET,EditText secondClubET)
    {
        if(isClubDuplicated(firstClubET,secondClubET)){
            Toast.makeText(context, "duplicated clubs", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!isClubExists(firstClubET) || !isClubExists(secondClubET)) {
            Toast.makeText(context, "Enter a valid club", Toast.LENGTH_SHORT).show();
            return false; }
        return true;
    }
    public boolean validClub(EditText clubET)
    {
        if(!isClubExists(clubET)){
            clubET.setError("Enter a valid club");
            return false;}
        return true;
    }

    public boolean validInputs(EditText firstClubET,EditText firstScoreET,EditText secondClubET, EditText secondScoreET)
    {
        if(isEmpty(firstClubET)||isEmpty(firstScoreET)||isEmpty(secondClubET)||isEmpty(secondScoreET)){
            Toast.makeText(context, "fill all the fields", Toast.LENGTH_SHORT).show();
            return false; }

        else if(!validClub(firstClubET,secondClubET))
            return false;

        return true;
    }
    public boolean validInputs(EditText club,EditText GP,EditText points,EditText win,EditText lose,EditText draw,EditText gi,EditText go)
    {
        if(isEmpty(club)||isEmpty(GP)||isEmpty(points)||isEmpty(win)||isEmpty(lose)||isEmpty(draw)||isEmpty(gi)||isEmpty(go)){
            Toast.makeText(context, "fill all the fields", Toast.LENGTH_SHORT).show();
            return false;}
        else if(!validClub(club))return false;
        return true;
    }
    public boolean validInputs(EditText club)
    {
        if(isEmpty(club)){
            club.setError("please enter club");
            return false; }
        else if(isClubExists(club)){
            club.setError("this club already exist");
            return false;}
        return true;
    }
}
