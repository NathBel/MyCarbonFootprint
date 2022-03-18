package com.iut.mycarbonfootprint;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.iut.mycarbonfootprint.Utils.ClientDbHelper;
import com.iut.mycarbonfootprint.Utils.History;
import com.iut.mycarbonfootprint.Utils.HistoryAdapter;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ArrayList<History> historyList;
    private ClientDbHelper clientDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        this.setTitle(getString(R.string.History));

        clientDbHelper = new ClientDbHelper(this);
        db = clientDbHelper.getWritableDatabase();
        ArrayList<ArrayList<String>> dbRes = clientDbHelper.selectAll(db);
        db.close();
        historyList = new ArrayList<>();

        madeHistory(dbRes);

        HistoryAdapter adapter = new HistoryAdapter(getApplicationContext(), R.layout.list_item, historyList);
        ListView listview = findViewById(R.id.historyView);
        listview.setAdapter(adapter);
    }

    public void madeHistory(ArrayList<ArrayList<String>> dbRes) {
        for (int i = 0; i < dbRes.size(); i++) {
            Log.v("VEHCIULE", dbRes.get(i).get(0));
            if ("1".equals(dbRes.get(i).get(0))) {
                historyList.add(new History(dbRes.get(i).get(1), dbRes.get(i).get(2), R.drawable.motorbike));
            } else if ("2".equals(dbRes.get(i).get(0))) {
                historyList.add(new History(dbRes.get(i).get(1), dbRes.get(i).get(2), R.drawable.sedan));
            } else if ("3".equals(dbRes.get(i).get(0))) {
                historyList.add(new History(dbRes.get(i).get(1), dbRes.get(i).get(2), R.drawable.train));
            }
        }
    }
}
