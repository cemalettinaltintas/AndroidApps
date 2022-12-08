package com.cemalettinaltintas.oop1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User myUser=new User("Oguz","Insructor");
        System.out.println(myUser);
        System.out.println(myUser.information());

        Musician emre=new Musician("Emre","Guitar",15);
        System.out.println(emre.getName());

        emre.setName("Emre Can");
        System.out.println(emre.getName());
        System.out.println(emre.getAge());
        //Inheritance
        SuperMusician lars=new SuperMusician("Lars","Drums",50);
        System.out.println(lars.sing());
        System.out.println(lars.getAge());

        //Polymorphism
        //Static polymorphism
        Mathematics mathematics=new Mathematics();
        System.out.println(mathematics.sum());
        System.out.println(mathematics.sum(5,3));
        System.out.println(mathematics.sum(2,3,4));

        //Dynamic Polymorphism
        Animal myAnimal=new Animal();
        myAnimal.sing();

        Dog myDog=new Dog();
        myDog.test();
        myDog.sing();

        Piano piano=new Piano();
        piano.brand="Yamaha";
        piano.digital=true;
        piano.info();
    }
}