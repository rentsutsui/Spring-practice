package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.practice.p04.q02.form.FavoriteForm;

@Controller
public class Practice0402Controller {

	@GetMapping("/favorite/input")
	public String favoriteInput() {
		return "practice04/02/favorite_input";
	}

	@PostMapping("/favorite/result")
	public String favoriteResult(FavoriteForm favoriteForm) {
		System.out.println("==パラメータを受け取りました");
		System.out.println("==果物 :" + favoriteForm.getFruit());
		System.out.println("==スナック:" + favoriteForm.getSnack());
		System.out.println("==スイーツ:" + favoriteForm.getSweet());
		System.out.println("==おかず :" + favoriteForm.getSidedish());
		return "practice04/02/favorite_result";
	}

}
