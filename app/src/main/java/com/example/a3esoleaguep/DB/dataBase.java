package com.example.a3esoleaguep.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a3esoleaguep.model.Club;
import com.example.a3esoleaguep.model.match;

import java.util.ArrayList;

public class
dataBase extends SQLiteOpenHelper {
    public static final String DatabaseName = "3esoLeague.db";

    public dataBase(Context con) {
        super(con, DatabaseName, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table league(club TEXT primary key ,GP INTEGER, points INTEGER, win INTEGER , draw INTEGER , lose INTEGER , GI INTEGER, GO INTEGER)");
        db.execSQL("create table matchResults(id INTEGER primary key AUTOINCREMENT,firstTeam TEXT,secondTeam TEXT, firstScore INTEGER , secondScore INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS league");
        db.execSQL("DROP TABLE IF EXISTS matchResults");
        onCreate(db);

    }

    public ArrayList<Club> getAllData() {
        ArrayList<Club> clubs = new ArrayList<>();
        SQLiteDatabase sq = getReadableDatabase();
        Cursor cursor = sq.rawQuery("SELECT * FROM league", null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            String club = cursor.getString(cursor.getColumnIndex("club"));
            int GP = cursor.getInt(cursor.getColumnIndex("GP"));
            int points = cursor.getInt(cursor.getColumnIndex("points"));
            int win = cursor.getInt(cursor.getColumnIndex("win"));
            int draw = cursor.getInt(cursor.getColumnIndex("draw"));
            int lose = cursor.getInt(cursor.getColumnIndex("lose"));
            int GI = cursor.getInt(cursor.getColumnIndex("GI"));
            int GO = cursor.getInt(cursor.getColumnIndex("GO"));

            clubs.add(new Club(club, GP, points, win, draw, lose, GI, GO));
            cursor.moveToNext();
        }
        return clubs;
    }

    public ArrayList<match> getAllMatches() {
        ArrayList<match> matches = new ArrayList<>();
        SQLiteDatabase sq = getReadableDatabase();
        Cursor cursor = sq.rawQuery("SELECT * FROM matchResults", null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String firstTeam = cursor.getString(cursor.getColumnIndex("firstTeam"));
            String secondTeam = cursor.getString(cursor.getColumnIndex("secondTeam"));
            int firstScore = cursor.getInt(cursor.getColumnIndex("firstScore"));
            int secondScore = cursor.getInt(cursor.getColumnIndex("secondScore"));

            matches.add(new match(id, firstTeam, secondTeam, firstScore, secondScore));
            cursor.moveToNext();
        }
        return matches;
    }
    public void repeatLeague()
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        for(int i=0;i<getAllData().size();i++) {
            ContentValues values = new ContentValues();
            values.put("GP", "0");
            values.put("points", "0");
            values.put("win", "0");
            values.put("draw", "0");
            values.put("lose", "0");
            values.put("GI", "0");
            values.put("GO", "0");
            sq.update("league", values, "club=?", new String[]{getAllData().get(i).getClub()});
        }
        deleteMatches();
    }
    public boolean insert_data(String c, int p, int w, int d, int l, int GI, int GO) {
        // object to insert data in the table
        SQLiteDatabase s = this.getWritableDatabase();
        //store the data
        ContentValues values = new ContentValues();
        values.put("club", c);
        values.put("points", p);
        values.put("win", w);
        values.put("draw", d);
        values.put("lose", l);
        values.put("GI", GI);
        values.put("GO", GO);
        long result = s.insert("league", null, values);
        if (result == -1) return false;
        else return true;
    }

    public boolean insertData(String firstTeam, String secondTeam, int firstScore, int secondScore) {
        SQLiteDatabase sq = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("firstTeam", firstTeam);
        values.put("firstScore", firstScore);
        values.put("secondTeam", secondTeam);
        values.put("secondScore", secondScore);
        long result = sq.insert("matchResults", null, values);
        if (result == -1) return false;
        return true;
    }

    public boolean insertData(String c) {
        // object to insert the data in table
        SQLiteDatabase s = this.getWritableDatabase();
        //store the data
        ContentValues values = new ContentValues();
        values.put("club", c);
        values.put("GP", "0");
        values.put("points", "0");
        values.put("win", "0");
        values.put("draw", "0");
        values.put("lose", "0");
        values.put("GI", "0");
        values.put("GO", "0");
        long result = s.insert("league", null, values);
        if (result == -1) return false;
        else return true;
    }

    public ArrayList getDataClub() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from league", null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            arrayList.add(c.getString(c.getColumnIndex("club")));
            c.moveToNext();
        }
        return arrayList;

    }

    public ArrayList getDataGP() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from league", null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            arrayList.add(c.getString(c.getColumnIndex("GP")));
            c.moveToNext();
        }
        return arrayList;
    }

    public ArrayList getDataPoints() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from league", null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            arrayList.add(c.getString(c.getColumnIndex("points")));
            c.moveToNext();
        }
        return arrayList;

    }

    public ArrayList getDataWin() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from league", null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            arrayList.add(c.getString(c.getColumnIndex("win")));
            c.moveToNext();
        }
        return arrayList;

    }

    public ArrayList getDataDraw() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from league", null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            arrayList.add(c.getString(c.getColumnIndex("draw")));
            c.moveToNext();
        }
        return arrayList;

    }

    public ArrayList getDataLose() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from league", null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            arrayList.add(c.getString(c.getColumnIndex("lose")));
            c.moveToNext();
        }
        return arrayList;

    }

    public ArrayList getDataGI() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from league", null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            arrayList.add(c.getString(c.getColumnIndex("GI")));
            c.moveToNext();
        }
        return arrayList;

    }

    public ArrayList getDataGO() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from league", null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            arrayList.add(c.getString(c.getColumnIndex("GO")));
            c.moveToNext();
        }
        return arrayList;

    }

    public void deleteClub(String c) {
        SQLiteDatabase sq = this.getWritableDatabase();
        sq.delete("league", "club=?", new String[]{c});
    }

    public boolean isClubExists(String club) {
        SQLiteDatabase sq = this.getWritableDatabase();
        Cursor cursor = sq.rawQuery("select * from league where club=?", new String[]{club});
        if (cursor.getCount() > 0) return true;
        return false;
    }

    public void updateData(String c, int GP, int p, int w, int d, int l, int GI, int GO) {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("GP", GP);
        values.put("points", p);
        values.put("win", w);
        values.put("draw", d);
        values.put("lose", l);
        values.put("GI", GI);
        values.put("GO", GO);
        sq.update("league", values, "club=?", new String[]{c});
    }

    public void updateAfterDeleteDrawMatch(String team, int GIScore, int GOScore) {
        int GP = 0, points = 0, draw = 0, GI = 0, GO = 0;

        for (int i = 0; i < getAllData().size(); i++) {
            if ((getAllData().get(i).getClub()).equals(team)) {
                GP = getAllData().get(i).getGP() - 1;
                points = getAllData().get(i).getPoints() - 1;
                draw = getAllData().get(i).getDraw() - 1;
                GI = getAllData().get(i).getGI() - GIScore;
                GO = getAllData().get(i).getGO() - GOScore;
                break;
            }
        }
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("GP",GP);
        values.put("points",points);
        values.put("draw",draw);
        values.put("GI",GI);
        values.put("GO",GO);
        sq.update("league",values,"club=?",new String[]{team});
    }
    public void updateAfterDeleteWinMatch(String team,int GIScore,int GOScore)
    {
        int GP=0,points=0,win=0,GI=0,GO=0;
        for(int i=0;i<getAllData().size();i++)
        {

            if((getAllData().get(i).getClub()).equals(team))
            {
                GP=getAllData().get(i).getGP()-1;
                points=getAllData().get(i).getPoints()-3;
                win=getAllData().get(i).getWin()-1;
                GI=getAllData().get(i).getGI()-GIScore;
                GO=getAllData().get(i).getGO()-GOScore;
                break;
            }
        }
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("GP",GP);
        values.put("points",points);
        values.put("win",win);
        values.put("GI",GI);
        values.put("GO",GO);
        sq.update("league",values,"club=?",new String[]{team});
    }
    public void updateAfterDeleteLoseMatch(String team,int GIScore,int GOScore)
    {
        int GP=0,lose=0,GI=0,GO=0;
        for(int i=0;i<getAllData().size();i++)
        {
            if((getAllData().get(i).getClub()).equals(team))
            {
                GP=getAllData().get(i).getGP()-1;
                lose=getAllData().get(i).getLose()-1;
                GI=getAllData().get(i).getGI()-GIScore;
                GO=getAllData().get(i).getGO()-GOScore;
                break;
            }
        }
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("GP",GP);
        values.put("lose",lose);
        values.put("GI",GI);
        values.put("GO",GO);
        sq.update("league",values,"club=?",new String[]{team});
    }
    public void updateAfterDeleteMatch(String team_show1 , String team_show2 , int result_show1 , int result_show2){
        SQLiteDatabase s = this.getWritableDatabase();


        if(result_show1 == result_show2){
            int draw = 0 , gINew = 0 , gONew = 0 , points = 0 , gPNew = 0 ;

            for(int i = 0 ; i<getAllData().size() ; i++) {
                if ((getAllData().get(i).getClub()).equalsIgnoreCase(team_show1)) {
                    draw = getAllData().get(i).getDraw() - 1 ;
                    gINew = getAllData().get(i).getGI() - result_show1;
                    gONew = getAllData().get(i).getGO() - result_show2;
                    points = getAllData().get(i).getPoints() - 1;
                    gPNew = getAllData().get(i).getGP() - 1;
                    ContentValues values = new ContentValues();
                    values.put("draw",draw);
                    values.put("GI",gINew);
                    values.put("GO",gONew);
                    values.put("points",points);
                    values.put("GP",gPNew);
                    s.update("league",values,"club=?",new String[]{team_show1});
                }
                if((getAllData().get(i).getClub()).equalsIgnoreCase(team_show2)){
                    draw = getAllData().get(i).getDraw() - 1 ;
                    gINew = getAllData().get(i).getGI() - result_show1;
                    gONew = getAllData().get(i).getGO() - result_show2;
                    points = getAllData().get(i).getPoints() - 1;
                    gPNew = getAllData().get(i).getGP() - 1;
                    ContentValues values = new ContentValues();
                    values.put("draw",draw);
                    values.put("GI",gINew);
                    values.put("GO",gONew);
                    values.put("points",points);
                    values.put("GP",gPNew);
                    s.update("league",values,"club=?",new String[]{team_show2});

                }

            }

        }
        else{

            int win = 0 , gINew = 0 , gONew = 0 , points = 0 , gPNew = 0 ;
            for(int i = 0 ; i<getAllData().size() ; i++) {
                if ((getAllData().get(i).getClub()).equalsIgnoreCase(team_show1)) {
                    win = getAllData().get(i).getWin() - 1 ;
                    gINew = getAllData().get(i).getGI() - result_show1 ;
                    gONew = getAllData().get(i).getGO() - result_show2 ;
                    points = getAllData().get(i).getPoints() - 3;
                    gPNew = getAllData().get(i).getGP() - 1;

                }
            }
            ContentValues values = new ContentValues();
            values.put("win",win);
            values.put("GI",gINew);
            values.put("GO",gONew);
            values.put("points",points);
            values.put("GP",gPNew);
            s.update("league",values,"club=?",new String[]{team_show1});

            int lose = 0  ;
            for(int i = 0 ; i<getAllData().size() ; i++) {
                if ((getAllData().get(i).getClub()).equalsIgnoreCase(team_show2)) {
                    lose = getAllData().get(i).getLose() - 1;
                    gINew = getAllData().get(i).getGI() - result_show2;
                    gONew = getAllData().get(i).getGO() - result_show1;
                    gPNew = getAllData().get(i).getGP() - 1;

                }
            }


            ContentValues values2 = new ContentValues();
            values2.put("lose",lose);
            values2.put("GI",gINew);
            values2.put("GO",gONew);
            values2.put("GP",gPNew);
            s.update("league",values2,"club=?",new String[]{team_show2});

        }

    }

    public void updateDataDraw(String c, int p, int d, int GI, int GO) {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("points", p);
        values.put("draw", d);
        values.put("GI", GI);
        values.put("GO", GO);
        sq.update("league", values, "club=?", new String[]{c});
    }

    public void updateDataWin(String c, int p, int w, int GI, int GO) {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("points", p);
        values.put("win", w);
        values.put("GI", GI);
        values.put("GO", GO);
        sq.update("league", values, "club=?", new String[]{c});
    }

    public void updateDataLose(String c, int l, int GI, int GO) {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("lose", l);
        values.put("GI", GI);
        values.put("GO", GO);
        sq.update("league", values, "club=?", new String[]{c});
    }

    public void updateWinnerData(String club, int GI, int GO) {
        int GP = 0, points = 0, win = 0, goalIn = 0, goalOut = 0;
        for (int i = 0; i < getAllData().size(); i++) {
            if ((getAllData().get(i).getClub()).equals(club)) {
                GP = getAllData().get(i).getGP();
                points = getAllData().get(i).getPoints();
                win = getAllData().get(i).getWin();
                goalIn = getAllData().get(i).getGI();
                goalOut = getAllData().get(i).getGO();

                GP += 1;
                points += 3;
                win += 1;
                goalIn += GI;
                goalOut += GO;
            }
        }
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("GP", GP);
        values.put("points", points);
        values.put("win", win);
        values.put("GI", goalIn);
        values.put("GO", goalOut);
        sq.update("league", values, "club=?", new String[]{club});
    }

    public void updateLoserData(String club, int GI, int GO) {
        int GP = 0, lose = 0, goalIn = 0, goalOut = 0;
        for (int i = 0; i < getAllData().size(); i++) {
            if ((getAllData().get(i).getClub()).equals(club)) {
                GP = getAllData().get(i).getGP();
                lose = getAllData().get(i).getLose();
                goalIn = getAllData().get(i).getGI();
                goalOut = getAllData().get(i).getGO();

                GP += 1;
                lose += 1;
                goalIn += GI;
                goalOut += GO;
            }
        }
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("GP", GP);
        values.put("lose", lose);
        values.put("GI", goalIn);
        values.put("GO", goalOut);
        sq.update("league", values, "club=?", new String[]{club});
    }

    public void updatedDrawData(String club, int GI, int GO) {
        int GP = 0, points = 0, draw = 0, goalIn = 0, goalOut = 0;
        for (int i = 0; i < getAllData().size(); i++) {
            if ((getAllData().get(i).getClub()).equals(club)) {
                GP = getAllData().get(i).getGP();
                points = getAllData().get(i).getPoints();
                draw = getAllData().get(i).getDraw();
                goalIn = getAllData().get(i).getGI();
                goalOut = getAllData().get(i).getGO();

                GP += 1;
                points += 1;
                draw += 1;
                goalIn += GI;
                goalOut += GO;
            }
        }
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("GP", GP);
        values.put("points", points);
        values.put("draw", draw);
        values.put("GI", goalIn);
        values.put("GO", goalOut);
        sq.update("league", values, "club=?", new String[]{club});
    }

    public void deleteData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("league", null, null);
        deleteMatches();
    }

    public void deleteMatches() {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete("matchResults", null, null);
    }

    public void deleteMatch(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("matchResults", "id=?", new String[]{String.valueOf(id)});
    }

    public boolean dataBaseIsEmpty() {
        SQLiteDatabase sq = this.getWritableDatabase();
        Cursor cursor = sq.rawQuery("select * from league", null);
        if (cursor.getCount() > 1) return false;
        return true;
    }

    public int dataCount() {
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor cursor = sq.rawQuery("select club from league", null);
        //long count2=DatabaseUtils.queryNumEntries(sq,"league"); //new
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public ArrayList<Club> sortData()
    {
        ArrayList<Club> clubs = new ArrayList<>();
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cursor=sq.rawQuery("SELECT * FROM league ORDER BY points DESC ,GI-GO DESC,GI DESC",null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            String club = cursor.getString(cursor.getColumnIndex("club"));
            int GP = cursor.getInt(cursor.getColumnIndex("GP"));
            int points = cursor.getInt(cursor.getColumnIndex("points"));
            int win = cursor.getInt(cursor.getColumnIndex("win"));
            int draw = cursor.getInt(cursor.getColumnIndex("draw"));
            int lose = cursor.getInt(cursor.getColumnIndex("lose"));
            int GI = cursor.getInt(cursor.getColumnIndex("GI"));
            int GO = cursor.getInt(cursor.getColumnIndex("GO"));

            clubs.add(new Club(club, GP, points, win, draw, lose, GI, GO));
            cursor.moveToNext();
        }
        return clubs;
    }

}


