package com.iut.mycarbonfootprint;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageButton voiture;
    private ImageButton moto;
    private ImageButton train;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voiture = findViewById(R.id.boutonVoiture);
        voiture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CarActivity.class);
                startActivity(intent);
            }
        });

        moto = findViewById(R.id.boutonMoto);
        moto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MotoActivity.class);
                startActivity(intent);
            }
        });

        train = findViewById(R.id.boutonTrain);
        train.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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

    @Override
    public boolean onOptionsItemSelected(MenuItem i) {
        int id = i.getItemId();
        if (id == R.id.menuHistory) {
            Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
            startActivity(intent);
        } else if (id == R.id.menuAbout) {
            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            intent.putExtra("info", "Vous venez du menu. (Intent)");
            startActivity(intent);
        }
        return super.onOptionsItemSelected(i);
    }
}