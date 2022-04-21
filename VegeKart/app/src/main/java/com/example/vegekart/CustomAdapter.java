package com.example.vegekart;

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
    public CustomAdapter(ArrayList<Model> data)
    {
        this.data=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycle_list, parent, false);
        return new ViewHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.TxtRecycle.setText(data.get(position).getTextView());
        holder.ImgRecycle.setImageResource(data.get(position).getImageView());
        holder.BtnRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
       private ImageView ImgRecycle;
       private TextView TxtRecycle;
       private Button BtnRecycle;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            this.ImgRecycle=itemView.findViewById(R.id.ImgRecycle);
            this.TxtRecycle=itemView.findViewById(R.id.TxtRecycle);
            this.BtnRecycle=itemView.findViewById(R.id.BtnRecycle);
        }
    }
}
