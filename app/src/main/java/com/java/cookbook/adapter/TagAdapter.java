package com.java.cookbook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.java.cookbook.HomepageFragment;
import com.java.cookbook.R;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {
    public static final String[] DEFAULT_TAGS = {"蛋类","虾","螃蟹","鱼","贝","烘培","奶制品","甜品","特色食品",};
    private final HomepageFragment fragment;
    private String[] tags = DEFAULT_TAGS;
    private int selectTag = 0;

    public TagAdapter(HomepageFragment fragment) {
        this.fragment = fragment;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tag_text,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(tags[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.notifyOntagClick(tags[holder.getAdapterPosition()]);
                TagAdapter.this.selectTag = holder.getAdapterPosition();
                TagAdapter.this.notifyDataSetChanged();
            }
        });
        if (selectTag == position){
            holder.text.setBackgroundResource(R.drawable.my_round_recentgle2);
        }else {
            holder.text.setBackgroundResource(R.drawable.my_round_recentgle1);
        }
    }

    @Override
    public int getItemCount() {
        return tags.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            this.text = itemView.findViewById(R.id.text);
        }
    }
}
