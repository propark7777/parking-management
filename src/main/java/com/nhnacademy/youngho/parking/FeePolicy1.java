package com.nhnacademy.youngho.parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FeePolicy1 implements FeePolicy{
    @Override
    public long calculateFee(Car car){
        long fee = 1000;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime enteringTime = car.getEnteringTime();
        int minute = (int) ChronoUnit.MINUTES.between(enteringTime,now);
        int day = (int)ChronoUnit.DAYS.between(enteringTime,now);
        int hour = (int)ChronoUnit.HOURS.between(enteringTime,now);

        if (day >=1){
            fee = 10_000L * day;
        }
        if(day == 0 && hour >= 6){
            fee = 10_000L;
        }
        if(day == 0 && minute > 30 && hour < 6){
            double additionalTime = (double) minute - 30;
            fee += (Math.ceil(additionalTime/10)) * 500;
        }
        if(day == 0 && minute <= 30){
            fee = 1_000L;
        }


        return fee;
    }
}
