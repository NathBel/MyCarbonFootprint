package com.iut.mycarbonfootprint;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toast.makeText(this, getIntent().getExtras().getString("info"), Toast.LENGTH_SHORT).show();
    }
}
