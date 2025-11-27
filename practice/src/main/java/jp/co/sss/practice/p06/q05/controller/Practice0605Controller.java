package jp.co.sss.practice.p06.q05.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.practice.p06.bean.FruitsSeasonBean;
import jp.co.sss.practice.p06.entity.FruitsSeason;
import jp.co.sss.practice.p06.form.FruitsSeasonForm;
import jp.co.sss.practice.p06.repository.FruitsSeasonRepository;

@Controller
public class Practice0605Controller {
	@Autowired
	FruitsSeasonRepository fruitRepository;

	@GetMapping("/fruits/add/input")
	public String showFruitInput() {
		return "practice06/05/fruit_input";
	}

	@PostMapping("/fruits/add/complete")
	public String registerFruit(FruitsSeasonForm fruitForm, Model model) {
		FruitsSeason fruit = new FruitsSeason();
		BeanUtils.copyProperties(fruitForm, fruit);
		fruit = fruitRepository.save(fruit);
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();
		model.addAttribute("fruit", fruitBean);
		return "practice06/05/fruit_detail";
	}

}
