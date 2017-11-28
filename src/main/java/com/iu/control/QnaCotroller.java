package com.iu.control;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.lang.jstl.EnumeratedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.qna.QnaDTO;

@Controller
@RequestMapping(value="/qna/*") //  /밑에 qna밑에 있는 것들 다
public class QnaCotroller {
	@RequestMapping(value="/qnaList", method={RequestMethod.GET, RequestMethod.POST})//get,post 두 방식으로 받고 싶을때
	public ModelAndView list(ModelAndView mv, @RequestParam(defaultValue="1", required=false)int curPage){
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("test1");
		qnaDTO.setWriter("choa");
		qnaDTO.setAge(28);
		mv.addObject("view", qnaDTO);
		mv.setViewName("qna/qnaList");
		System.out.println(curPage);
		return mv;
	}
	
	/*@RequestMapping(value="/qnaView")
	public String view(HttpServletRequest request){
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("test");
		qnaDTO.setWriter("iu");
		qnaDTO.setAge(25);
		request.setAttribute("view", qnaDTO);
		return "qna/qnaView";
	} 첫번째 방법*/
	
	
	/*@RequestMapping(value="/qnaView")
	public String view(Model model){
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("test1");
		qnaDTO.setWriter("choa");
		qnaDTO.setAge(28);
		model.addAttribute("view", qnaDTO);
		/.addAttribute("board", "QNA"); Chainning할 때/ 
		return "qna/qnaView";
	} 두번째 방법*/
	
	
	
	@RequestMapping(value="/qnaWrite", method=RequestMethod.GET)
	public void Write(){
		
	}//요청URI
	
	
	//parameter가지고 오는 방법
	/*@RequestMapping(value="/qnaWrite", method=RequestMethod.POST)
	public String Write(HttpServletRequest request){
		String title = request.getParameter("title");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println(title);
		System.out.println(age);
		return "qna/qnaList";
	}*/ //첫번째 방법 값을 너지 않으면 null이 뜸
	
	
	/*@RequestMapping(value="/qnaWrite", method=RequestMethod.POST)
	public String Write(@RequestParam(value="title")String subject, String writer, int age, String [] name){ //parameter타입에 맞게 적어주면 자동 mapping됨
		for(String s : name){	//checkbox같이 여러개 올때는 배열화, @RequestParam(value="title"): 변수명이 다르나 같은 값을 출력하고 싶을때
			System.out.println(s);
		}
		System.out.println(subject);
		System.out.println(writer);
		System.out.println(age);
		return "qna/qnaList";
	}//두번째 방법 하나를 비워두고 보내면 비운곳에 null이 옴*/
	
	
	/*@RequestMapping(value="/qnaWrite", method=RequestMethod.POST)
	public String Write(QnaDTO qnaDTO, String title){ //parameter타입에 맞게 적어주면 자동 mapping됨
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle(subject);
		qnaDTO.setWriter(writer);
		qnaDTO.setAge(age);
		qnaDTO.setName(name);
		
		for(String s : qnaDTO.getName()){	//checkbox같이 여러개 올때는 배열화, @RequestParam(value="title"): 변수명이 다르나 같은 값을 출력하고 싶을때
			System.out.println(s);
		}
		System.out.println("qnaDTO : "+qnaDTO.getTitle());
		System.out.println(qnaDTO.getWriter());
		System.out.println("title : " + title);
		System.out.println(qnaDTO.getAge());
		
		return ".qna/qnaList";
	}//세번째 방법	
	
*/
	@RequestMapping(value="qnaWrite", method= RequestMethod.POST)
	public String write(QnaDTO qnaDTO, String title){
		
			for(String s : qnaDTO.getName()){
				System.out.println(s);
			}
			System.out.println("DTO : "+qnaDTO.getTitle());
			System.out.println("title : "+title);
			System.out.println(qnaDTO.getWriter());
			System.out.println(qnaDTO.getAge());
		return "redirect:./qnaList?curPage=5";
	}
}
