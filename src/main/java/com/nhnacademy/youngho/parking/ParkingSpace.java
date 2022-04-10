package com.nhnacademy.youngho.parking;

public class ParkingSpace {
    String areaCode;
    Car car;

    public ParkingSpace(String areaCode, Car car) {
        this.areaCode = areaCode;
        this.car = car;
    }

    public String getCode() {
        return areaCode;
    }

    public Car getCar() {
        return car;
    }

    public void setCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
