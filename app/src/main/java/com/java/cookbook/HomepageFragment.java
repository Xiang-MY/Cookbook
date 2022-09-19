package com.java.cookbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.lang.Thread;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.java.cookbook.adapter.RecipeAdapter;
import com.java.cookbook.adapter.TagAdapter;
import com.java.cookbook.pojo.RecipeBean;
import com.java.cookbook.util.NetUtil;

import java.util.ArrayList;
import java.util.List;


public class HomepageFragment extends Fragment {
    private RecyclerView recy_homepage;
    private RecyclerView recy_view_tags;
    private String currentTag = TagAdapter.DEFAULT_TAGS[0];
    private List<RecipeBean> recipeList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage,container,false);
        initView(view);
        return view;
    }

    private void initView(View view){
        recy_homepage = view.findViewById(R.id.recy_homepage);
        recy_view_tags=view.findViewById(R.id.recy_view_tags);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recy_view_tags.setLayoutManager(layoutManager);
        recy_view_tags.setAdapter(new TagAdapter(this));
    }

    public void notifyOntagClick(String tag){
        currentTag = tag;
        initData();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        NetUtil.queryRecipe(currentTag, new NetUtil.OnRecipeQueriedCallback() {
            @Override
            public void onSuccess(List<RecipeBean> recipes) {
                if(getActivity() == null) return;
                recipeList.clear();
                recipeList.addAll(recipes);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecipeAdapter adapter = new RecipeAdapter(getActivity(),recipeList);
                        StaggeredGridLayoutManager st = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                        recy_homepage.setLayoutManager(st);
                        recy_homepage.setAdapter(adapter);
                    }
                });
            }

            @Override
            public void onFailure(Exception e) {
                if(getActivity()==null) return;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(),"网络错误",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}