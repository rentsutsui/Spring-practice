package jp.co.sss.practice.p12.q01.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Practice1201Controller {

	@GetMapping("/fortune")
	public String showFortuneResult(Model model) {
		Integer fortuneNum = (int) (Math.floor(Math.random() * 5) + 1);
		System.out.println("## Practice1201 ## fortuneNum:" + fortuneNum);
		Date today = new Date();
		model.addAttribute("today", today);
		model.addAttribute("fortuneNum", fortuneNum);
		return "practice12/01/fortune";
	}

}
