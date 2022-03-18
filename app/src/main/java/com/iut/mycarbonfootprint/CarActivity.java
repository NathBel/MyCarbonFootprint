package com.iut.mycarbonfootprint;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.iut.mycarbonfootprint.Utils.ClientDbHelper;

public class CarActivity extends AppCompatActivity {

    private double conso;
    private ClientDbHelper clientDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        clientDbHelper = new ClientDbHelper(this);
        db = clientDbHelper.getWritableDatabase();
    }

    public void Calculate(View view) {
        EditText editText = this.findViewById(R.id.Nb_km);
        String value = editText.getText().toString();
        double dist = Integer.parseInt(value);

        EditText editText2 = this.findViewById(R.id.NbpassagerEdit);
        String value2 = editText2.getText().toString();
        int nbpassager = Integer.parseInt(value2);
        RadioButton rb1 = this.findViewById(R.id.Electrique);
        RadioButton rb2 = this.findViewById(R.id.Thermique);
        if (rb1.isChecked()) {
            conso = 0.02;
        } else if (rb2.isChecked()) {
            conso = 0.19;
        }
        float result = (float) ((conso * dist) / nbpassager);
        TextView tonTextView = findViewById(R.id.Result);
        tonTextView.setText("Consommation estimée : " + result + " kgCO2e par passager");

        ContentValues values = new ContentValues();
        values.put("result", result);
        values.put("distance", dist);
        values.put("type", 2);
        db.insert("History", null, values);
    }
}