package com.springbook.view.controller;

//  Controller가 리턴한 view 이름에 접두사(prepix)와 접미사(suffix)를 결합하여 최종적으로 실행될 View 경로와 파일 명 완성 
// DispatcherServlet의 init()메소드 호출시 생성 
public class ViewResolver {
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
