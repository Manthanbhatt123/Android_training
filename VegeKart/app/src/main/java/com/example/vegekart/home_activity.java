package com.example.vegekart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class home_activity extends AppCompatActivity implements View.OnClickListener {

    ImageButton BtnShop1,BtnShop2,BtnShop3,BtnShop4,BtnShop5,BtnShop6,BtnShop7,BtnShop8,BtnShop9,BtnShop10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);
        BtnShop1=findViewById(R.id.BtnShop1);
        BtnShop1.setOnClickListener(this);
        BtnShop2=findViewById(R.id.BtnShop2);
        BtnShop2.setOnClickListener(this);
        BtnShop3=findViewById(R.id.BtnShop3);
        BtnShop3.setOnClickListener(this);
        BtnShop4=findViewById(R.id.BtnShop4);
        BtnShop4.setOnClickListener(this);
        BtnShop5=findViewById(R.id.BtnShop5);
        BtnShop5.setOnClickListener(this);
        BtnShop6=findViewById(R.id.BtnShop6);
        BtnShop6.setOnClickListener(this);
        BtnShop7=findViewById(R.id.BtnShop7);
        BtnShop7.setOnClickListener(this);
        BtnShop8=findViewById(R.id.BtnShop8);
        BtnShop8.setOnClickListener(this);
        BtnShop9=findViewById(R.id.BtnShop9);
        BtnShop9.setOnClickListener(this);
        BtnShop10=findViewById(R.id.BtnShop10);
        BtnShop10.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            Intent i=new Intent(home_activity.this, RecycleMain.class);
            startActivity(i);
    }
}