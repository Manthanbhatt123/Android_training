package com.example.vegekart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class RecycleMain extends AppCompatActivity
{
    RecyclerView recycleview;
    ArrayList<Model> alModel=new ArrayList<>();
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_main);
        recycleview = findViewById(R.id.recycleMain);

             for (int i=0;i<=20;i++)
                {   Model m = new Model();
                m.setImageView(R.drawable.abc);
                m.setTextView("Name "+ (i+1) );
                alModel.add(m);
            }

            customAdapter = new CustomAdapter(alModel);
            recycleview.setLayoutManager(new LinearLayoutManager(this));
            recycleview.setAdapter(customAdapter);
//        recycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        }
}
