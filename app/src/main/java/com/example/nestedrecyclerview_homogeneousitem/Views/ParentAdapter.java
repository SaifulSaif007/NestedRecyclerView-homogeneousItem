package com.example.nestedrecyclerview_homogeneousitem.Views;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview_homogeneousitem.Models.Parent;
import com.example.nestedrecyclerview_homogeneousitem.R;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> implements ChildAdapter.itemClickListner{


    List<Parent>parentList;
    ParentItemClick itemClick;

    public ParentAdapter(List<Parent> parentList, ParentItemClick click) {
        this.parentList = parentList;
        this.itemClick = click;
    }

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();


    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recycler_item, parent, false);
        return new ParentViewHolder(view, itemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        Parent present = parentList.get(position);
        holder.genre.setText(present.getGenre());

        LinearLayoutManager childLayoutManager = new LinearLayoutManager(holder.rv_child.getContext(), RecyclerView.HORIZONTAL, false);
        childLayoutManager.setInitialPrefetchItemCount(4);

        holder.rv_child.setLayoutManager(childLayoutManager);
        holder.rv_child.setAdapter(new ChildAdapter(present.getChildren(), this));
        holder.rv_child.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    @Override
    public void onItemClick(int position) {
        Log.e("Clicked", ""+ position);
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RecyclerView rv_child;
        TextView genre;
        ParentItemClick click;

        public ParentViewHolder(@NonNull View itemView, ParentItemClick itemClick) {
            super(itemView);

            genre = itemView.findViewById(R.id.movie_genre);
            rv_child = itemView.findViewById(R.id.rv_child);
            this.click = itemClick;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            click.parentClick(getAdapterPosition());
        }
    }

    public interface ParentItemClick{
        void parentClick(int position);
    }
}
