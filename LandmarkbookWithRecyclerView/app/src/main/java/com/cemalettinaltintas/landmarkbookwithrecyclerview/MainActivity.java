package com.cemalettinaltintas.landmarkbookwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.cemalettinaltintas.landmarkbookwithrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

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

        Landmark pisa=new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark colloseum=new Landmark("Colloseum","France",R.drawable.colloseum);
        Landmark london=new Landmark("London Bridge","UK",R.drawable.london);
        Landmark eiffel=new Landmark("Eiffel Tower","France",R.drawable.eiffel);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(colloseum);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(london);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter=new LandmarkAdapter(landmarkArrayList);

        binding.recyclerView.setAdapter(landmarkAdapter);


    }

}