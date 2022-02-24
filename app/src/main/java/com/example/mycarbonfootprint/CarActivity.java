package com.example.mycarbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class CarActivity extends AppCompatActivity {

    double conso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
    }

    public void Calculate(View view){
        EditText editText = (EditText) this.findViewById(R.id.Nb_km);
        String value= editText.getText().toString();
        double dist = Integer.parseInt(value);

        EditText editText2 = (EditText) this.findViewById(R.id.NbpassagerEdit);
        String value2= editText2.getText().toString();
        int nbpassager = Integer.parseInt(value2);
        RadioButton rb1 = (RadioButton) this.findViewById(R.id.Electrique);
        RadioButton rb2 = (RadioButton) this.findViewById(R.id.Thermique);
        if (rb1.isChecked()){
            conso = 0.02;
        } else if (rb2.isChecked()){
            conso = 0.19;
        }
        double result = (conso * dist) / nbpassager;
        TextView tonTextView = (TextView)findViewById(R.id.Result);
        tonTextView.setText("Consommation estimée : " + result + " kgCO2e par passager");
    }
}