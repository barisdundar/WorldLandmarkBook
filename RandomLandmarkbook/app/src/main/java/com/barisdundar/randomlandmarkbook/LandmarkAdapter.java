package com.barisdundar.randomlandmarkbook;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barisdundar.randomlandmarkbook.databinding.RecyclerviewRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {
    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewRowBinding recyclerviewRowBinding=RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
       return new LandmarkHolder(recyclerviewRowBinding);
        //xml bağlama işlemleri burada yapılır
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
        holder.binding.RecyclerViewTextView.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
//layout içerisinde hangi veriler gözükmek istiyorsa burada gözükecek

    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{
   private RecyclerviewRowBinding binding;
        public LandmarkHolder(RecyclerviewRowBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }
}
