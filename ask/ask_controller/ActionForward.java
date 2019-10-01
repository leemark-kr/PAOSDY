package com.ask.action;

public class ActionForward {
	//컨트롤러에서 페이지를 이동할 때 사용하는 이동정보를 저장하는 객체
	private String path; //이동할 위치,장소
	private boolean isRedirect; //어떻게 이동할지 나타내는 변수
	
	//클래스안에 생성자가 없으니까 디폴트생성자를 만들어준다 디폴트값은 false
	
	//get메서드, set메서드
	public String getPath() { 
		return path;
	}
	public void setPath(String path) { 
		this.path = path;
	}
	public boolean isRedirect() { 
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
