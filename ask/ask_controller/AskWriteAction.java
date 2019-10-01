package com.ask.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ask.db.AskDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AskWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AskWriteAction_execute()**********");
		
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
		
		//문의 관련 파일 업로드할 가상경로(upload 폴더 생성)
		String realPath = request.getRealPath("/ask_upload");
		
		//업로드할 파일의 크기 지정 2MB
		int maxSize = 2*1024*1024;
		
		//MultipartRequest 객체 생성
		String fileName="";
		String originalFileName="";
		
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		Enumeration formNames = multi.getFileNames();
		String formName = (String)formNames.nextElement();
		fileName = multi.getFilesystemName(formName);
		
		
		//글의 정보를 저장(폼 데이터)
		AskDTO askdto = new AskDTO();
		askdto.setAsk_member_id(multi.getParameter("id"));
		askdto.setAsk_num(Integer.parseInt(multi.getParameter("")));
		askdto.setAsk_item_num(Integer.parseInt(multi.getParameter("")));
		askdto.setAsk_title(multi.getParameter("ask_title"));
		askdto.setAsk_content(multi.getParameter(""));
		askdto.setAsk_open(Integer.parseInt(multi.getParameter("")));
		askdto.setAsk_category(multi.getParameter("ask_category"));
		askdto.setAsk_answer(Integer.parseInt(multi.getParameter("")));
		askdto.setAsk_file(multi.getFilesystemName("ask_file"));
		
		
		//페이지 이동("./ask/ask_list.jsp")
		ActionForward forward = new ActionForward(); //
		forward.setPath("./ask/ask_write.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
