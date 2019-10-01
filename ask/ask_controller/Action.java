package com.ask.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//추상메서드
	//이동정보를 리턴하는 ActionForward
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
