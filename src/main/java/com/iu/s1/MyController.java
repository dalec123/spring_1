package com.iu.s1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//annotation생성
@Controller	//controller역활을 함
public class MyController {
	
	@RequestMapping(value="/notice/noticeList")//요청주소
	public String go(HttpServletRequest request){  //HttpServletRequest request 내장객체로 너음
			
		String name = request.getParameter("name");
		System.out.println("name :" + name);
		
		return "notice/noticeList"; //jsp의 이름만 적음
	}
	
	@RequestMapping(value="/notice/noticeView")
	public String view(){
		return "notice/noticeView";
	}
}
