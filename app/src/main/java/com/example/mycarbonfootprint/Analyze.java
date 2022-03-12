package com.example.mycarbonfootprint;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Analyze extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);
    }

    public void print(View view){
        DbManager db = new DbManager(this);
        String res = db.toString();
        Toast.makeText(this,"Test : " + res, Toast.LENGTH_LONG).show();
    }
}
