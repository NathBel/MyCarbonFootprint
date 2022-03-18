package com.iut.mycarbonfootprint;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.iut.mycarbonfootprint.Utils.ClientDbHelper;

public class HistoryActivity extends AppCompatActivity {
    private ClientDbHelper clientDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        clientDbHelper = new ClientDbHelper(this);
        db = clientDbHelper.getWritableDatabase();
        clientDbHelper.selectAll(db);
        db.close();
    }
}
