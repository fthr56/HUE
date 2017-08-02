package com.example.demo.base;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import baseball.Baseball;

@Controller
public class BaseballController {
	ArrayList<Integer> comBall = Baseball.generateComputerBalls();
	@GetMapping("/baseball")
	public ModelAndView input(String inputValue) {

		ModelAndView mav = new ModelAndView("baseball/result");
		System.out.println("input value : " + inputValue);

		ArrayList<Integer> userBall = Baseball.inputUserBalls(inputValue);
		String result = Baseball.calculateBalls(comBall,userBall);
		
		mav.addObject("value", inputValue);
		mav.addObject("comBall", comBall);
		mav.addObject("result", result);
		return mav;
	}

	@GetMapping("/newgame")
	public ModelAndView newgame(String inputValue) {
		comBall = Baseball.generateComputerBalls();
		
		ModelAndView mav = new ModelAndView("redirect:/baseball/form.html");
		return mav;
	}
}
