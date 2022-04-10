package com.nhnacademy.youngho.parking;

public class Exit {
    private ParkingSystem parkingSystem;

    public Exit(){

    }
    public Exit(ParkingSystem parkingSystem) {
        this.parkingSystem = parkingSystem;
    }

    public String checkExiting(Car car){
        return car.getPlate();
    }

}
