package com.example.nestedrecyclerview_homogeneousitem.Views;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview_homogeneousitem.Models.Child;
import com.example.nestedrecyclerview_homogeneousitem.R;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder>{


    List<Child> childList;

    public ChildAdapter(List<Child> childList) {
        this.childList = childList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_recycler_item, parent, false);
        return new ChildViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {

        holder.Image.setImageResource(childList.get(position).getImage());
        holder.Title.setText(childList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return childList.size();
    }


    class ChildViewHolder extends RecyclerView.ViewHolder {

         TextView Title;
         ImageView Image;

        private ChildViewHolder(@NonNull View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.movie_title);
            Image = itemView.findViewById(R.id.movie_image);
        }
    }
}
