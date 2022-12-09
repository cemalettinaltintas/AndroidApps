package com.cemalettinaltintas.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.cemalettinaltintas.landmarkbook.databinding.ActivityDetailsBinding;
import com.cemalettinaltintas.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList=new ArrayList<>();

        //Data
        Landmark pisa=new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark eiffel=new Landmark("Eiffel","France",R.drawable.eifel);
        Landmark londonBridge=new Landmark("London Bridge","UK",R.drawable.london);
        Landmark colloseum=new Landmark("Colloseum","Italy",R.drawable.colloseum);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colloseum);
        landmarkArrayList.add(londonBridge);
        //adapter

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList()));

        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this,landmarkArrayList.get(i).name,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(i));
                startActivity(intent);
            }
        });
    }
}