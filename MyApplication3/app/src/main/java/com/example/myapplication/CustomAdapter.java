package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>
{
    private ArrayList<Model> data;

    public CustomAdapter (ArrayList<Model> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw, parent, false);
        return new ViewHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(data.get(position).getName());
        holder.imgView.setImageResource(data.get(position).getImage());
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Integer count=0;
                data.get(position).setCart(1);
                for(int i=0;i<data.size();i++)
                {
                    if(data.get(i).getCart()==1)
                    {
                        count++;
                        holder.btnRemove.setVisibility(View.VISIBLE);
                        holder.btnAdd.setVisibility(View.GONE);
                    }

                }
                MainActivity.txtCount.setText(""+count);
            }
        });

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Integer count=0;
                data.get(position).setCart(0);
                for(int i=0;i<data.size();i++)
                {
                    if(data.get(i).getCart()==0)
                    {
                        count--;
                        holder.btnRemove.setVisibility(View.GONE);
                        holder.btnAdd.setVisibility(View.VISIBLE);
                    }
                }
                MainActivity.txtCount.setText(""+count);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgView;
        private TextView txtName;
        private Button btnAdd,btnRemove;

        public ViewHolder(View view) {
            super(view);
            this.imgView = view.findViewById(R.id.imgView);
            this.txtName = view.findViewById(R.id.txtName);
            this.btnAdd = view.findViewById(R.id.btnAdd);
            this.btnRemove= view.findViewById(R.id.btnRemove);
        }
    }
}
