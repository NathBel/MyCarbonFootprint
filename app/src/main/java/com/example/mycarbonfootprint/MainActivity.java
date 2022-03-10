package com.example.mycarbonfootprint;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageButton voiture;
    private ImageButton moto;
    private ImageButton train;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voiture = (ImageButton) findViewById(R.id.boutonVoiture);
        voiture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), CarActivity.class);
                startActivity(intent);
            }
        });

        moto = (ImageButton) findViewById(R.id.boutonMoto);
        moto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MotoActivity.class);
                startActivity(intent);
            }
        });

        train = (ImageButton) findViewById(R.id.boutonTrain);
        train.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), TrainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, m);
        return true;
    }


}