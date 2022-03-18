package com.iut.mycarbonfootprint.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.iut.mycarbonfootprint.R;

import java.util.ArrayList;

public class HistoryAdapter extends ArrayAdapter<History> {
    private final ArrayList<History> historyList;

    public HistoryAdapter(@NonNull Context context, int resource, ArrayList<History> historyList) {
        super(context, resource);
        this.historyList = historyList;
    }

    @Override
    public int getCount() {
        return this.historyList.size();
    }

    @Nullable
    @Override
    public History getItem(int position) {
        return this.historyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView vehicleImage = convertView.findViewById(R.id.vehicle_imageview);
        TextView dist = convertView.findViewById(R.id.dist);
        TextView conso = convertView.findViewById(R.id.conso);

        vehicleImage.setImageResource(historyList.get(position).getVehicleId());
        dist.setText(historyList.get(position).getDistance() + " Km");
        conso.setText(historyList.get(position).getConsommation() + " kgCO2e");

        return convertView;
    }
}