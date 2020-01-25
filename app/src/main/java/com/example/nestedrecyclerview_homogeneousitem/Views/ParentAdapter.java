package com.example.nestedrecyclerview_homogeneousitem.Views;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview_homogeneousitem.Models.Parent;
import com.example.nestedrecyclerview_homogeneousitem.R;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder>{


    List<Parent>parentList;

    public ParentAdapter(List<Parent> parentList) {
        this.parentList = parentList;
    }


    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rv_child;
        TextView genre;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            genre = itemView.findViewById(R.id.movie_genre);
            rv_child = itemView.findViewById(R.id.rv_child);
        }
    }
}
