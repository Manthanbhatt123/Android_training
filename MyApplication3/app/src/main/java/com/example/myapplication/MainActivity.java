package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;
    ArrayList<Model> alModel=new ArrayList<>();
    CustomAdapter customAdapter;
    public static TextView txtCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView=findViewById(R.id.recycleView);
        txtCount=findViewById(R.id.txtCount);

        for(int i=0;i<20;i++)
        {
            Model m=new Model();
            m.setImage(R.drawable.bird);
            m.setName("Name : "+ (i+1));
            m.setCart(0);
            alModel.add(m);
        }

        customAdapter=new CustomAdapter(alModel);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(customAdapter);
//        recycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}