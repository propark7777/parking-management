package com.nhnacademy.youngho.parking;

import java.time.LocalDateTime;

public class Entrance {

    public String checkEntering(Car car){
        car.setEnterTime(LocalDateTime.now());
        return car.getPlate();
    }

}
