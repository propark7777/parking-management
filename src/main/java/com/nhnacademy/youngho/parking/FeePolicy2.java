package com.nhnacademy.youngho.parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FeePolicy2 implements FeePolicy{
    @Override
    public long calculateFee(Car car) {
        long fee = 0L;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime enteringTime = car.getEnteringTime();
        int minute = (int) ChronoUnit.MINUTES.between(enteringTime,now);
        int day = (int)ChronoUnit.DAYS.between(enteringTime,now);


        if (day >=1){
            fee = 15_000L * day;
        }
        if(day == 0 && minute > 60 ){
            double additionalTime = (double) minute - 60;
            fee += 1_000L+ ((Math.ceil(additionalTime/10)) * 500);
        }
        if(day == 0 && minute > 30 && minute <= 60){
            fee = 1_000L;
        }
        if(day == 0 && minute <= 30){
            fee = 0L;
        }
        if (car instanceof CompactCar){
            fee = (long) (fee * 0.5);
        }

        return fee;
    }
}
