package com.cemalettinaltintas.landmarkbookwithrecyclerview;

public class Singleton {
    private Landmark sentLanmark;
    private static Singleton singleton;
    private Singleton(){
    }

    public Landmark getSentLanmark() {
        return sentLanmark;
    }

    public void setSentLanmark(Landmark sentLenmark) {
        this.sentLanmark = sentLenmark;
    }

    public static Singleton getInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
}
