package com.cemalettinaltintas.oop1;

public class Dog extends Animal{
    public void test(){
        super.sing();
    }
    public void sing(){
        System.out.println("Dog class");
    }
}
