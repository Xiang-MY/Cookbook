package com.java.cookbook.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.java.cookbook.R;
import com.java.cookbook.RecipeDetailActivity;
import com.java.cookbook.pojo.RecipeBean;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private Context mcontext;
    private List<RecipeBean> recipeList;
    public RecipeAdapter(Context mcontext,List<RecipeBean> recipeList){
        this.mcontext = mcontext;
        this.recipeList = recipeList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.recycler_item,parent,false);
        ViewHolder myholder = new ViewHolder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(final RecipeAdapter.ViewHolder myholder, int position) {
        final RecipeBean courseInfo = recipeList.get(position);
        myholder.item_title.setText(courseInfo.getCpName());
        myholder.item_user.setText(courseInfo.getDes());
        Glide.with(mcontext).load(courseInfo.getSmallImg()).into(myholder.item_img);
        myholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //单击跳转到菜谱详情页
                Intent intent = new Intent(mcontext, RecipeDetailActivity.class);
                intent.putExtra("data",courseInfo);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView item_img;
        TextView item_title,item_user;
        public ViewHolder(View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.item_image);
            item_title = itemView.findViewById(R.id.item_title);
            item_user = itemView.findViewById(R.id.item_user);
        }
    }
}
