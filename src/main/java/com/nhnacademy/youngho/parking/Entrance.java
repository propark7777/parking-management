package com.nhnacademy.youngho.parking;

import java.time.LocalDateTime;

public class Entrance {

    public String checkEntering(Car car){
        if(car instanceof FullSizeCar){
            throw new IllegalCarTypeException();
        }
        car.setEnterTime(LocalDateTime.now());
        return car.getPlate();
    }

}
