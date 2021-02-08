package com.springbook.view.controller;

//  Controller�� ������ view �̸��� ���λ�(prepix)�� ���̻�(suffix)�� �����Ͽ� ���������� ����� View ��ο� ���� �� �ϼ� 
// DispatcherServlet�� init()�޼ҵ� ȣ��� ���� 
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
