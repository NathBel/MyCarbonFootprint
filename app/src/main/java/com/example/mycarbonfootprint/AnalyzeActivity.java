package com.example.mycarbonfootprint;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycarbonfootprint.Utils.MyDatabaseHelper;

public class AnalyzeActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
    }

    public void print(View view) {
        dbHelper.getWritableDatabase();
        Toast.makeText(this, "Created DB.", Toast.LENGTH_LONG).show();
    }
}
