package com.java.cookbook.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    //根据位置返回当前碎片
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    //碎片的总数
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
