package com.loveplusplus.demo.image;

import java.util.ArrayList;

public class MessageModle {

	public int code;
	public String msg;
	
	public ArrayList<InfoBean> list;

	@Override
	public String toString() {
		return "MyMessage [code=" + code + ", msg=" + msg + ", list=" + list + "]";
	}

	
	
}
