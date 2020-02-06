package com.example.nestedrecyclerview_homogeneousitem.Views;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview_homogeneousitem.Models.Parent;
import com.example.nestedrecyclerview_homogeneousitem.R;
import com.example.nestedrecyclerview_homogeneousitem.ViewModel.ParentDataFactory;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> implements ChildAdapter.itemClickListner{


    List<Parent>parentList;
    Context context;

    public ParentAdapter(List<Parent> parentList, Context context) {
        this.parentList = parentList;
        this.context = context;
    }

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();


    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recycler_item, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        Parent present = parentList.get(position);
        holder.genre.setText(present.getGenre());

        LinearLayoutManager childLayoutManager = new LinearLayoutManager(holder.rv_child.getContext(), RecyclerView.HORIZONTAL, false);
        childLayoutManager.setInitialPrefetchItemCount(4);

        holder.rv_child.setLayoutManager(childLayoutManager);
        holder.rv_child.setAdapter(new ChildAdapter(present.getChildren(), this, context));
        holder.rv_child.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    @Override
    public int onItemClick(int position) {
        Log.e("Clicked", ""+ position);
        return  position;
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder  {

        RecyclerView rv_child;
        TextView genre;


        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            genre = itemView.findViewById(R.id.movie_genre);
            rv_child = itemView.findViewById(R.id.rv_child);


        }

    }

}
