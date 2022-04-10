package com.nhnacademy.youngho.parking;

import java.time.LocalDateTime;

public class Car {
    private String plate;
    private long myMoney;
    private LocalDateTime enteringTime;

    public Car(String plate) {
        this.plate = plate;
    }

    public Car(String plate, long myMoney, LocalDateTime enteringTime) {
        this.plate = plate;
        this.myMoney = myMoney;
        this.enteringTime = enteringTime;
    }

    public String getPlate() {
        return plate;
    }

    public long getMyMoney() {
        return myMoney;
    }

    public LocalDateTime getEnteringTime() {
        return enteringTime;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setMyMoney(long myMoney) {
        this.myMoney = myMoney;
    }

    public void setEnterTime(LocalDateTime enteringTime) {
        this.enteringTime = enteringTime;
    }

    public ParkingSpace parkTo(String areaCode){
        return new ParkingSpace(areaCode,new Car(this.plate));
    }

    public void payFee(FeePolicy feePolicy){
        long fee = feePolicy.calculateFee(this);
        long myMoney = this.myMoney;
        if(myMoney < fee){
            throw new InsufficientCashException();
        }
        long result = myMoney - fee;
        this.setMyMoney(result);
    }

}
