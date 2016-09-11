package com.yzh.itteam.service;

public interface ISuccessAndFailListener {
		public boolean onFail(int status, Object msg);
		public boolean onSuccess(int status, Object msg);
}
