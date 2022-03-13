package com.example.mycarbonfootprint;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DbManager extends SQLiteOpenHelper{

    public static final int dbVersion = 1;
    public static final String dbName = "CarbonFootPrint.db";

    public final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Users (id INTEGER PRIMARY KEY, CarbonRate REAL)";
    public final String SQL_DELETE = "DROP TABLE IF EXISTS Users";
    public final String SQL_SELECT = "SELECT * FROM Users";

    public DbManager(Context context) {
        super(context, dbName, null ,dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }

    public String addRecord(int p1, float p2){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("id", p1);
        cv.put("CarbonRate", p2);

        long res = db.insert("Users", null, cv);
        db.close();
        if(res==1){
            return "Failed";
        }
        else{
            return "Successfully";
        }
    }

    @SuppressLint("Range")
    public String dbToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.rawQuery(SQL_SELECT, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("CarbonRate")) != null){
                dbString += c.getString(c.getColumnIndex("CarbonRate"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
