package com.yzh.itteam.service;

public class DisPatcher {
	private ISuccessAndFailListener mSimpleListener;
	public void addSuccessAndFailListener(ISuccessAndFailListener listener) {
		mSimpleListener = listener;
	}

	public void handleonSuccess(int status,Object msg){
		mSimpleListener.onSuccess(status,msg);
	}
	public void handleonFail(int status,Object msg){
		mSimpleListener.onFail(status,msg);
	}
	
}
