package com.iut.mycarbonfootprint.Utils;

public class History {
    private final String distance;
    private final String consommation;
    private final int vehicleId; //1 for car, 2 for motorbike and 3 for train

    public History(String distance, String consommation, int vehicleId) {
        this.distance = distance;
        this.consommation = consommation;
        this.vehicleId = vehicleId;
    }

    public String getDistance() {
        return distance;
    }

    public String getConsommation() {
        return consommation;
    }

    public int getVehicleId() {
        return vehicleId;
    }
}