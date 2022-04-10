package com.nhnacademy.youngho.parking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PayTest {
    ParkingSystem parkingSystem;
    Car car;

    @BeforeEach
    void setUp() {
        parkingSystem = new ParkingSystem();
        car = mock(Car.class);
    }

    @DisplayName("출구에서 결제(30분이하 주차)")
    @Test
    void payFor30m() {

        String plate = "A5570";
        long money = 1_000L;
        LocalDateTime before30m = LocalDateTime.now().minusMinutes(30);

        Car car = new Car(plate, money, before30m);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(1_000L);
    }

    @DisplayName("출구에서 결제(6시간이상 주차)")
    @Test
    void payForOver6Hour() {

        String plate = "A5570";
        long money = 20_000L;
        LocalDateTime over6Hour = LocalDateTime.now().minusHours(6);

        Car car = new Car(plate, money, over6Hour);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(10_000L);
    }

    @DisplayName("출구에서 결제(2일 주차)")
    @Test
    void payForOverDay() {

        String plate = "A5570";
        long money = 20_000L;
        LocalDateTime overDay = LocalDateTime.now().minusDays(2);

        Car car = new Car(plate, money, overDay);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(20_000L);
    }

    @DisplayName("출구에서 결제(61분 주차)")
    @Test
    void payFor61m() {

        String plate = "A5570";
        long money = 20_000L;
        LocalDateTime overtime = LocalDateTime.now().minusMinutes(61);

        Car car = new Car(plate, money, overtime);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(3_000L);
    }

    @DisplayName("출구에서 결제(50분 주차)")
    @Test
    void payFor50m() {

        String plate = "A5570";
        long money = 20_000L;
        LocalDateTime overtime = LocalDateTime.now().minusMinutes(50);

        Car car = new Car(plate, money, overtime);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(2_000L);
    }
}
