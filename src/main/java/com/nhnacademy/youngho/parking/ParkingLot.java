package com.nhnacademy.youngho.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpace> spaces = new ArrayList<>();
    private ParkingInfo parkingInfo;
    private Entrance entrance;
    private Exit exit;

    public List<ParkingSpace> getSpaces() {
        return spaces;
    }

    public ParkingInfo getParkingInfo() {
        return parkingInfo;
    }

    public Entrance getEnterance() {
        return entrance;
    }

    public Exit getExit() {
        return exit;
    }


}
