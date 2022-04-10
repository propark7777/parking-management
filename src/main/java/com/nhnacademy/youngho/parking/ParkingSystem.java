package com.nhnacademy.youngho.parking;

import java.util.List;

public class ParkingSystem {
    ParkingLot parkingLot = new ParkingLot();
    ParkingInfo parkingInfo = new ParkingInfo();
    FeePolicy feePolicy;


    public FeePolicy getFeePolicy() {
        return feePolicy;
    }

    public ParkingSystem(){

    }

    public ParkingSystem(FeePolicy feePolicy){
        this.feePolicy = feePolicy;
    }


    public boolean checkCarInParkingLot(ParkingSpace parkingSpace){
        List<ParkingSpace> spaces = parkingLot.getSpaces();
        for(ParkingSpace ps : spaces){
            if(ps.getCar().equals(parkingSpace.getCar()) &&
                ps.getCode().equals(parkingSpace.getCode())){
                return true;
            }
        }
        return false;
    }

    public ParkingSpace findParkingSpaceByCar(Car car){
        List<ParkingSpace> spaces = parkingInfo.getParkingSpaceList();
        for(ParkingSpace ps : spaces){
            if(ps.getCar().equals(car)){
                return ps;
            }
        }
        return null;
    }

    public boolean addParkingInfo(Car car, String areaCode){
        return parkingInfo.getParkingSpaceList().add(car.parkTo(areaCode));

    }

    public void removeParkingInfo(Car car){
        ParkingSpace parkingSpace = findParkingSpaceByCar(car);
        parkingInfo.getParkingSpaceList().remove(parkingSpace);
    }

    public void exit(Car car){
        car.payFee(feePolicy);
        removeParkingInfo(car);
    }



}
