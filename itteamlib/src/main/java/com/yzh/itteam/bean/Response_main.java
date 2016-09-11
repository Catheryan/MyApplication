package com.yzh.itteam.bean;

import java.util.List;

public class Response_main<T> {
	public String code;
	public String rows;
	public List<T> result;
}
