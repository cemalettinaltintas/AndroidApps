package com.cemalettinaltintas.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //Veritabanı bulunğumuz aktiviteden türetiyoruz.
            SQLiteDatabase database=this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY, name VARCHAR,age INT)");
            //SQLite verileri herkesin kendi veritabanında tutuluyor.
//            database.execSQL("INSERT INTO musicians (name,age) VALUES('Lars',60)");
//            database.execSQL("INSERT INTO musicians (name,age) VALUES('James',50)");
//            database.execSQL("INSERT INTO musicians (name,age) VALUES('Kirk',55)");
//            database.execSQL("UPDATE musicians set age=61 WHERE name='Lars'");
//            database.execSQL("UPDATE musicians set name='Kirk Hammett' WHERE id=3");
//            Cursor cursor=database.rawQuery("SELECT * FROM musicians WHERE age>52",null);
            Cursor cursor=database.rawQuery("SELECT * FROM musicians WHERE name LIKE 'J%'",null);
            int nameIx=cursor.getColumnIndex("name");
            int ageIx=cursor.getColumnIndex("age");
            int idIx=cursor.getColumnIndex("id");
            while (cursor.moveToNext()){
                System.out.println("Name :"+cursor.getString(nameIx));
                System.out.println("Age :"+cursor.getString(ageIx));
                System.out.println("Id :"+cursor.getInt(idIx));
            }
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}