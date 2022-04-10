package com.nhnacademy.youngho.parking;

import java.time.LocalDateTime;

public class FullSizeCar extends Car{
    public FullSizeCar(String plate) {
        super(plate);
    }

    public FullSizeCar(String plate, long myMoney, LocalDateTime enteringTime) {
        super(plate, myMoney, enteringTime);
    }
}
