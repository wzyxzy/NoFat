package com.wzy.nofat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wzy.nofat.R;
import com.wzy.nofat.model.Tikongcan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2016/4/12.
 */
public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> implements View.OnClickListener {
    private List<Tikongcan.RecipeListEntity> data;
    private LayoutInflater inflater;
    private RecyclerView recyclerView;
    private OnItemClickListener listener;

    public RecipeListAdapter(Context context, List<Tikongcan.RecipeListEntity> data) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (data == null) {
            this.data = new ArrayList<>();
        } else {
            this.data = data;

        }
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
    public void updateRes(List<Tikongcan.RecipeListEntity> data){
        if (data!=null){
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=inflater.inflate(R.layout.three_recipe_gv_item,parent,false);
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(data.get(position).getName());
        Glide.with(holder.image.getContext()).load(data.get(position).getPic()).into(holder.image);

    }
    @Override
    public int getItemCount() {
        return data != null ? data.size():0;
    }

    @Override
    public void onClick(View v) {
        if (recyclerView!=null){
            int childAdapterPosition=recyclerView.getChildAdapterPosition(v);
            if (listener!=null){
                listener.onItemClick(childAdapterPosition,data.get(childAdapterPosition));
            }
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }
    public interface OnItemClickListener {
        void onItemClick(int position, Tikongcan.RecipeListEntity recipeListEntity);
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            image= (ImageView) itemView.findViewById(R.id.three_recipe_img);
            text= (TextView) itemView.findViewById(R.id.three_recipe_text);

        }
    }
}
