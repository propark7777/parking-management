package com.nhnacademy.youngho.parking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChangedFeePolicyTest {
    ParkingSystem parkingSystem;
    Car car;

    @BeforeEach
    void setUp() {
        parkingSystem = new ParkingSystem(new FeePolicy2());
        car = mock(Car.class);
    }

    @DisplayName("30분이하 무료")
    @Test
    void payFor30m() {

        String plate = "A5570";
        long money = 1_000L;
        LocalDateTime before30m = LocalDateTime.now().minusMinutes(30);

        Car car = new Car(plate, money, before30m);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isZero();
    }

    @DisplayName("30분~1시간: 1000원")
    @Test
    void payFor30to60m() {

        String plate = "A5570";
        long money = 20_000L;
        LocalDateTime over6Hour = LocalDateTime.now().minusMinutes(43);

        Car car = new Car(plate, money, over6Hour);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(1_000L);
    }

    @DisplayName("1시간이후 10분당 추가 500원")
    @Test
    void payForOver1h() {

        String plate = "A5570";
        long money = 20_000L;
        LocalDateTime overDay = LocalDateTime.now().minusMinutes(63);

        Car car = new Car(plate, money, overDay);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(1500);
    }

    @DisplayName("1일주차")
    @Test
    void payForDay() {

        String plate = "A5570";
        long money = 50_000L;
        LocalDateTime overDay = LocalDateTime.now().minusDays(3);

        Car car = new Car(plate, money, overDay);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(45_000L);
    }

    @DisplayName("경차할인")
    @Test
    void discountCompactCar(){
        String plate = "A5570";
        long money = 50_000L;
        LocalDateTime overDay = LocalDateTime.now().minusDays(3);

        Car car = new CompactCar(plate, money, overDay);
        Exit exit = mock(Exit.class);

        when(exit.checkExiting(car)).thenReturn(plate);
        assertThat(parkingSystem.getFeePolicy().calculateFee(car)).isEqualTo(22_500L);
    }

}
