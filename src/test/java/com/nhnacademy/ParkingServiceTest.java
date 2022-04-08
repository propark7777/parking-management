package com.nhnacademy;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ParkingServiceTest {
    Car car;
    CarRepository carRepository;
    ParkingService parkingService;
    @BeforeEach
    void setUp() {
        carRepository = mock(CarRepository.class);
        parkingService = new ParkingService(carRepository);
    }
    @DisplayName("주차장에 차가 들어온다.")
    @Test


    @Test
    void calculateFee() {
    }
}