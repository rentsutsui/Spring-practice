package jp.co.sss.practice.p12.q03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Practice1203Controller {

	@GetMapping("/layout/first")
	public String showLayoutFirst() {
		return "practice12/03/first";
	}

	@GetMapping("/layout/second")
	public String showLayoutSecond() {
		return "practice12/03/second";
	}

	@GetMapping("/layout/third")
	public String showLayoutThird() {
		return "practice12/03/third";
	}
}
