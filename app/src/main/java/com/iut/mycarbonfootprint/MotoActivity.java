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

public class MotoActivity extends AppCompatActivity {

    double conso;
    private ClientDbHelper clientDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);
        clientDbHelper = new ClientDbHelper(this);
        db = clientDbHelper.getWritableDatabase();
    }

    public void Calculate(View view) {
        EditText editText = (EditText) this.findViewById(R.id.Nb_km);
        String value= editText.getText().toString();
        double dist = Integer.parseInt(value);

        EditText editText2 = (EditText) this.findViewById(R.id.NbpassagerEdit);
        String value2= editText2.getText().toString();
        int nbpassager = Integer.parseInt(value2);
        RadioButton rb1 = (RadioButton) this.findViewById(R.id.Moto);
        RadioButton rb2 = (RadioButton) this.findViewById(R.id.Scooter);
        if (rb1.isChecked()) {
            conso = 0.168;
        } else if (rb2.isChecked()) {
            conso = 0.062;
        }
        double result = (conso * dist) / nbpassager;
        TextView tonTextView = (TextView) findViewById(R.id.Result);
        tonTextView.setText("Consommation estimée : " + result + " kgCO2e par passager");

        ContentValues values = new ContentValues();
        values.put("result", result);
        values.put("distance", dist);
        values.put("type", 1);
        db.insert("History", null, values);
    }

}