package com.example.mycarbonfootprint;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycarbonfootprint.Utils.ClientDbHelper;

public class OLDAnalyzeActivity extends AppCompatActivity {
    private ClientDbHelper clientDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);
        clientDbHelper = new ClientDbHelper(this);
        db = clientDbHelper.getWritableDatabase();
    }

    public void print(View view) {
        ContentValues values = new ContentValues();
        //values.put("result", "4.0");
        //db.insert("History", null, values);
        clientDbHelper.selectAll(db);
        //db.close();
        Toast.makeText(this, "Created DB.", Toast.LENGTH_LONG).show();
    }
}
