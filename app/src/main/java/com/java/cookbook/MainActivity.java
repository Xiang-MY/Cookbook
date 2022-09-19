package com.java.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.java.cookbook.adapter.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager view_pager; //ViewPager控件
    private RadioGroup radio_group; //单选按钮纽组
    private RadioButton radio_homepage,radio_classify,radio_personal_center; //按钮首页，分类，个人中心
    private Fragment homepageFragment,classifyFragment,personalCenterFragment;
    private List<Fragment> fragmentList = new ArrayList<>();
    private int positon = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView(); //绑定控件
        initData(); //将碎片类添加到ViewPager容器中
        initMove(); //滑屏时按钮随着变化
        initOnclick(); //单击按钮，碎片随着变化
    }

    //绑定控件
    private void initView(){
        view_pager =(ViewPager) findViewById(R.id.view_pager);
        radio_group = (RadioGroup) findViewById(R.id.radio_group);
        radio_homepage = (RadioButton) findViewById(R.id.radio_homePage);
        radio_classify = (RadioButton) findViewById(R.id.radio_classify);
        radio_personal_center = (RadioButton) findViewById(R.id.radio_personal_center);
    }

    private void initData(){
        //将碎片实例化，存放到动态数组
        homepageFragment = new HomepageFragment();
        classifyFragment = new ClassifyFragment();
        personalCenterFragment = new PersonalCenterFragment();
        fragmentList.add(homepageFragment);
        fragmentList.add(classifyFragment);
        fragmentList.add(personalCenterFragment);
        //创建自定义适配器的实例
        MyFragmentAdapter adapter = new MyFragmentAdapter(this.getSupportFragmentManager(),fragmentList);
        //为ViewPager绑定适配器
        view_pager.setAdapter(adapter);
    }

    private void initMove(){
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton)radio_group.getChildAt(position)).setChecked(true);//滑屏时pisition改变了，导航栏按钮也会改变
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initOnclick(){
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_homePage:
                        positon = 0;
                        view_pager.setCurrentItem(positon);
                        break;
                    case R.id.radio_classify:
                        positon = 1;
                        view_pager.setCurrentItem(positon);
                        break;
                    case R.id.radio_personal_center:
                        positon = 2;
                        view_pager.setCurrentItem(positon);
                        break;
                    default:
                        positon = 0;
                        view_pager.setCurrentItem(positon);
                        break;
                }
            }
        });
    }
}

