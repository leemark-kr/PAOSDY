package com.ask.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AskFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess!");
		
		//가상 주소를 가져와서 처리
		String requestURI = request.getRequestURI();
		System.out.println(" requestURI : "+requestURI);
		String contextPath = request.getContextPath();
		System.out.println(" contextPath : "+contextPath);
		String command = requestURI.substring(contextPath.length());
		System.out.println(" command : "+command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/AskWrite.qa")){
			forward = new ActionForward();
			forward.setPath("./ask/ask_write.jsp"); 
			forward.setRedirect(false);
		}else if(command.equals("/AskWriteAction.qa")){
			
		}else if(command.equals("/AskList.qa")){
			//new AskListAction();
			action = new AskListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/AskRewrite.qa")){
			//new AskRewriteAction();
		}
		
		
		//가상주소를 가지고 이동
		if(forward != null){
			if(forward.isRedirect()){//true
				response.sendRedirect(forward.getPath());
			}else{//false
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
}
