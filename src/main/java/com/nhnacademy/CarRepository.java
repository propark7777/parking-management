package com.nhnacademy;

public interface CarRepository {
    void registerCar(Car car);

    Car findByPlate(String plate);

}
