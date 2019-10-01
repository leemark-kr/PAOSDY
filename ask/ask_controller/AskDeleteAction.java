package com.ask.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AskDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AskDeleteAction_execute()**********");
		/*
		//ID 세션 체크
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ActionForward forward = new ActionForward();
		if(id == null){
			forward.setPath("");
			forward.setRedirect(true);
			return forward;
		}
		*/
		
		
		
		
		//페이지 이동("./AskList.qa")
		ActionForward forward = new ActionForward(); //
		forward.setPath("./AskList.qa");
		forward.setRedirect(false);
		return forward;
	}

}
