package com.example.demo.base;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

	ArrayList<Question> questions = new ArrayList<>();

	@GetMapping("qnas/form")
	public String qnaform() {
		return "qna/form";
	}
	
	@GetMapping("/qnas/{index}")
	public ModelAndView show(@PathVariable int index) {
		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("question", questions.get(index));
		return mav;
	}
	
	@PostMapping("/qnas")
	public ModelAndView writeQuestion(Question question) {
		System.out.println("name = " + question.writer);
		System.out.println("title = " + question.title);
		System.out.println("content = " + question.contents);
		
		questions.add(question);
		System.out.println("size: " + questions.size());
		
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/")
	public ModelAndView putQuestion() {
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("questions", questions);
		return mav;
	}
}
