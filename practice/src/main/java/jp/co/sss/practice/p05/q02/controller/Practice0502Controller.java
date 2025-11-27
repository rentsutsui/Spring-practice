package jp.co.sss.practice.p05.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0502Controller {

	@GetMapping("/numguess/start")
	public String showNumguessStart(HttpSession session) {
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
		System.out.println("当たりの値:" + hitNumber);
		session.setAttribute("hitNumber", hitNumber);
		return "practice05/02/numguess_start";
	}

	@GetMapping("/numguess/input")
	public String showNumguessInput() {
		return "practice05/02/numguess_input";
	}

	@GetMapping("/numguess/judge")
	public String showNumguessJudge(HttpSession session, Integer inputNum) {
		Integer hitNumber = (Integer) session.getAttribute("hitNumber");
		if (inputNum == hitNumber) {
			return "redirect:/numguess/hit";
		}
		return "practice05/02/numguess_judge";
	}

	@GetMapping("/numguess/hit")
	public String showNumguessHit(Model model, HttpSession session) {
		Integer hitNumber = (Integer) session.getAttribute("hitNumber");
		String message = "当たり！正解は" + hitNumber + "です。";
		session.removeAttribute("hitNumber");
		model.addAttribute("message", message);
		return "practice05/02/numguess_end";
	}

}
