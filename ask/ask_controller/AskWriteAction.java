package com.ask.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ask.db.AskDAO;
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
		
		//제목이 null이면 자동 입력
		String ask_title = request.getParameter("ask_title");
		if(ask_title==""){
			ask_title="";
		}
		
		//글의 정보를 저장(폼 데이터)
		AskDTO askdto = new AskDTO();
		askdto.setAsk_member_id(multi.getParameter("id")); //회원ID
		askdto.setAsk_num(Integer.parseInt(multi.getParameter("ask_num"))); //문의사항 게시물 번호
		askdto.setAsk_item_num(Integer.parseInt(multi.getParameter("ask_item_num"))); //문의사항 해당 제품번호
		askdto.setAsk_title(multi.getParameter("ask_title")); //문의사항 제목
		askdto.setAsk_content(multi.getParameter("ask_content")); //문의사항 본문내용
		askdto.setAsk_open(Integer.parseInt(multi.getParameter("ask_open"))); //문의사항 비밀글여부
		askdto.setAsk_category(multi.getParameter("ask_category")); //문의사항 구분
		askdto.setAsk_answer(Integer.parseInt(multi.getParameter("ask_answer"))); //문의사항 답변여부
		askdto.setAsk_file(multi.getFilesystemName("ask_file")); //문의사항 업로드파일
		
		//AskDAO 처리 객체 생성 저장
		AskDAO askdao = new AskDAO();
		
		//insertAsk(DTO)
		
		
		//페이지 이동("./AskList.qa")
		ActionForward forward = new ActionForward(); //
		forward.setPath("./AskList.qa");
		forward.setRedirect(false);
		return forward;
	}

}
