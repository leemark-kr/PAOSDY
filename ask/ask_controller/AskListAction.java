package com.ask.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AskListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		
		
		
		//페이지 이동("./ask/ask_list.jsp")
		ActionForward forward = new ActionForward(); //
		forward.setPath("./ask/ask_list.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
