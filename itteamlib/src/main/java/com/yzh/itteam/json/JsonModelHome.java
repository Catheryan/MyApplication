package com.yzh.itteam.json;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.yzh.itteam.bean.Contants;
import com.yzh.itteam.bean.EngineBeaninfo;
import com.yzh.itteam.bean.Response_main;
import com.yzh.itteam.service.DisPatcher;
import com.yzh.itteam.tools.ToolHTTP;

import org.json.JSONObject;
import org.apache.http.Header;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static com.baidu.platform.comapi.d.c.D;

/**
 * Created by yzh on 201/9/11.
 */

public class JsonModelHome extends DisPatcher{
    private Context mContext;
    public JsonModelHome(Context context) {
        this.mContext =context;
    }
    public void getEngineInfo(){
        ToolHTTP.get(mContext, Contants.equipmentBrief, null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  JSONObject response) {
                Log.i("Cache", response.toString());
                //tips:msg是服务器返回的消息
                Gson gson = new Gson();
                Response_main<EngineBeaninfo> resultBean = gson.fromJson(response.toString(), new TypeToken<Response_main<EngineBeaninfo>>() {
                }.getType());
                if (Integer.valueOf(resultBean.code)==1) {
                    handleonSuccess(Integer.valueOf(resultBean.code),resultBean);
                    return ;
                }else if(Integer.valueOf(resultBean.code)==2){
                    handleonFail(Integer.valueOf(resultBean.code),"获取失败");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  String responseString, Throwable throwable) {
                handleonFail(2,"获取失败");
            }

        }, "UTF-8");

    }
}
