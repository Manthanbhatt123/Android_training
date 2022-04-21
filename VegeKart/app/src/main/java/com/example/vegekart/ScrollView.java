package com.example.vegekart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ScrollView extends AppCompatActivity  implements View.OnClickListener{

    ImageView ImgPrdt1,ImgPrdt2,ImgPrdt3,ImgPrdt4;
    TextView TxtPrdt1,TxtPrdt2,TxtPrdt3,TxtPrdt4,TxtPrdtQnty1,TxtPrdtQnty2,TxtPrdtQnty3,TxtPrdtQnty4;
    Button Btnprdt1,Btnprdt2,Btnprdt3,Btnprdt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
    }

    @Override
    public void onClick(View view) {
    }
}