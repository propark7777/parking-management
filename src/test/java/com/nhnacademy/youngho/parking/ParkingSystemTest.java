package com.nhnacademy.youngho.parking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ParkingSystemTest {
    ParkingSystem parkingSystem;
    Car car;

    @BeforeEach
    void setUp() {
        parkingSystem = new ParkingSystem();
    }
    @DisplayName("주차장에 차가 들어온다.")
    @Test
    void checkEnterToParkingLot(){
        String plate = "A5570";

        car = new Car(plate);
        Entrance entrance = new Entrance();
        assertThat(entrance.checkEntering(car)).isEqualTo("A5570");
    }

    @DisplayName("A-1에 주차한다.")
    @Test
    void checkParkingInParkingSpaceWell(){
        Car car = mock(Car.class);
        ParkingSpace parkingSpace = mock(ParkingSpace.class);
        String areaCode = "A-1";
        when(car.parkTo(areaCode)).thenReturn(parkingSpace);
        assertThat(parkingSystem.addParkingInfo(car,areaCode)).isTrue();

    }

    @DisplayName("출구에서 결제(30분이하 주차)")
    @Test
    void checkExitFromParkingLot(){
        String plate = "A5570";
        long money = 1_000L;
        LocalDateTime before30m = LocalDateTime.now().minusMinutes(30);

        Car car = new Car(plate, money, before30m);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(1_000L);

    }

    @DisplayName("입구가 2개")
    @Test
    void checkTwoEntrance(){
        Car car1 = new Car("A1234");
        Car car2 = new Car("B5678");
        Entrance entrance1 = new Entrance();
        Entrance entrance2 = new Entrance();

        assertThat(entrance1.checkEntering(car1)).isEqualTo("A1234");
        assertThat(entrance2.checkEntering(car2)).isEqualTo("B5678");
    }

    @DisplayName("출구가 2개")
    @Test
    void checkTwoExit(){
        Car car1 = new Car("A1234");
        Car car2 = new Car("B5678");
        Exit exit1 = new Exit();
        Exit exit2 = new Exit();

        assertThat(exit1.checkExiting(car1)).isEqualTo("A1234");
        assertThat(exit2.checkExiting(car2)).isEqualTo("B5678");
    }
    
    

}