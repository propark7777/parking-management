package com.nhnacademy.youngho.parking;

public class IllegalCarTypeException extends IllegalArgumentException{
    public IllegalCarTypeException() {
        super("대형차는 주차할 수 없습니다.");
    }
}
