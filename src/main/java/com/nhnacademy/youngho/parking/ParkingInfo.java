package com.nhnacademy.youngho.parking;

import java.util.ArrayList;
import java.util.List;


public class ParkingInfo {
    private List<ParkingSpace> parkingSpaceList = new ArrayList<>();

    public List<ParkingSpace> getParkingSpaceList() {
        return parkingSpaceList;
    }
    public  ParkingInfo(){

    }
    public ParkingInfo(List<ParkingSpace> parkingSpaceList) {
        this.parkingSpaceList = parkingSpaceList;
    }
}
