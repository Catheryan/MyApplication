package com.itteam.yzh.android.demo.home.activity;

import android.content.Context;
import android.view.View;

import com.itteam.yzh.android.myapplication.R;
import com.yzh.itteam.base.BaseFragmentV4;
import com.yzh.itteam.bean.EngineBeaninfo;
import com.yzh.itteam.bean.Response_main;
import com.yzh.itteam.json.JsonModelHome;
import com.yzh.itteam.service.ISuccessAndFailListener;
import com.yzh.itteam.tools.ToolHTTP;

/**
 * Created by yzh on 2016/9/6.
 */

public class HomeFragment extends BaseFragmentV4 implements ISuccessAndFailListener{
    @Override
    public int bindLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness(Context context) {
        JsonModelHome jsonModelHome =new JsonModelHome(getContext());
        jsonModelHome.addSuccessAndFailListener(this);
        jsonModelHome.getEngineInfo();

    }

    @Override
    public boolean onFail(int status, Object msg) {
        Response_main<EngineBeaninfo> response_main = (Response_main<EngineBeaninfo>) msg;
        return false;
    }

    @Override
    public boolean onSuccess(int status, Object msg) {
        String result = (String) msg;
        return false;
    }
}
