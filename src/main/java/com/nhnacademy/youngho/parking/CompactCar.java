package com.nhnacademy.youngho.parking;

import java.time.LocalDateTime;

public class CompactCar extends Car{
    public CompactCar(String plate) {
        super(plate);
    }

    public CompactCar(String plate, long myMoney, LocalDateTime enteringTime) {
        super(plate, myMoney, enteringTime);
    }
}
