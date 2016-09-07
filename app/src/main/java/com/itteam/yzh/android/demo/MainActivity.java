package com.itteam.yzh.android.demo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.itteam.yzh.android.demo.home.entity.TabEntity;
import com.itteam.yzh.android.demo.my.activity.MyFragment;
import com.itteam.yzh.android.myapplication.R;
import com.itteam.yzh.android.demo.home.activity.HomeFragment;
import com.itteam.yzh.android.demo.rizhi.activity.RizhiFragment;
import com.itteam.yzh.android.demo.tangkou.activity.TangkouFragment;
import com.yzh.itteam.base.BaseFragmentActivity;

import java.util.ArrayList;

public class MainActivity extends BaseFragmentActivity {

    private String[] mTitles = {"首页", "塘口", "日志", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.home_1, R.mipmap.tangkou_1,
            R.mipmap.rizhi_1, R.mipmap.wo_1};
    private int[] mIconSelectIds = {
            R.mipmap.home_2, R.mipmap.tangkou_2,
            R.mipmap.rizhi_2 , R.mipmap.wo_2};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments2 = new ArrayList<>();
    private Fragment homeFragment = new HomeFragment();
    private Fragment tangkouFragment = new TangkouFragment();
    private Fragment rizhiFragment = new RizhiFragment();
    private Fragment myFragment = new MyFragment();
    private CommonTabLayout mTabLayout_3;
    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        mTabLayout_3 = (CommonTabLayout)view.findViewById(R.id.tl_2);
    }

    @Override
    public void doBusiness(Context context) {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mFragments2.add(homeFragment);
        mFragments2.add(tangkouFragment);
        mFragments2.add(rizhiFragment);
        mFragments2.add(myFragment);
        mTabLayout_3.setTabData(mTabEntities, this, R.id.fl_change, mFragments2);
        mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mTabLayout_3.setCurrentTab(0);
        mTabLayout_3.showDot(1);
    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

    }
}
