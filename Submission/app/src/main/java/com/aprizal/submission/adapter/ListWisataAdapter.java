package com.aprizal.submission.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aprizal.submission.R;
import com.aprizal.submission.from.Wisata;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListWisataAdapter extends RecyclerView.Adapter<ListWisataAdapter.CategoryViewHolder> {
    private ArrayList<Wisata> listWisata;
    public ListWisataAdapter(ArrayList<Wisata> list) {
        this.listWisata = list;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_wisata, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder holder, final int position) {
    final Wisata wisata = listWisata.get(position);
        Glide.with(holder.itemView.getContext()).load(wisata.getPhoto()).apply(new RequestOptions().override(655, 655)).into(holder.imgPhoto);
        holder.tvName.setText(wisata.getName());
        holder.tvDetail.setText(wisata.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listWisata.get(holder.getAdapterPosition()),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }

     static class CategoryViewHolder extends RecyclerView.ViewHolder {
         ImageView imgPhoto;
         TextView tvName;
         TextView tvDetail;

         CategoryViewHolder(@NonNull final View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);

         }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Wisata wisata , int position);
    }
}
