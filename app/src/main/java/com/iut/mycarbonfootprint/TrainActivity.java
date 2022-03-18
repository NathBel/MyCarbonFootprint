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

public class TrainActivity extends AppCompatActivity {

    double conso;
    private ClientDbHelper clientDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        clientDbHelper = new ClientDbHelper(this);
        db = clientDbHelper.getWritableDatabase();
    }

    public void Calculate(View view) {
        EditText editText = (EditText) this.findViewById(R.id.Nb_km);
        String value= editText.getText().toString();
        double dist = Integer.parseInt(value);

        RadioButton rb1 = (RadioButton) this.findViewById(R.id.Metro);
        RadioButton rb2 = (RadioButton) this.findViewById(R.id.RER);
        RadioButton rb3 = (RadioButton) this.findViewById(R.id.Intercités);
        RadioButton rb4 = (RadioButton) this.findViewById(R.id.Tramway);
        RadioButton rb5 = (RadioButton) this.findViewById(R.id.TER);
        RadioButton rb6 = (RadioButton) this.findViewById(R.id.TGV);
        if (rb1.isChecked()){
            conso = 0.003;
        } else if (rb2.isChecked()){
            conso = 0.004;
        }
        else if (rb3.isChecked()){
            conso = 0.005;
        }
        else if (rb4.isChecked()){
            conso = 0.002;
        } else if (rb5.isChecked()) {
            conso = 0.025;
        } else if (rb6.isChecked()) {
            conso = 0.002;
        }
        double result = (conso * dist);
        TextView tonTextView = (TextView) findViewById(R.id.Result);
        tonTextView.setText("Consommation estimée : " + result + " kgCO2e par passager");

        ContentValues values = new ContentValues();
        values.put("result", result);
        values.put("distance", dist);
        values.put("type", 3);
        db.insert("History", null, values);
    }


}