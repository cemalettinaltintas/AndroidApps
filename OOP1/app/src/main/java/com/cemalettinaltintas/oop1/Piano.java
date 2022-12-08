package com.cemalettinaltintas.oop1;

public class Piano implements  Instrument,HouseDecor{
    String brand;
    boolean digital;

    @Override
    public void info() {
        System.out.println("Override methods");
    }
}
