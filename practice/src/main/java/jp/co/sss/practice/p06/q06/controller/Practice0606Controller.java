package jp.co.sss.practice.p06.q06.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.practice.p06.bean.FruitsSeasonBean;
import jp.co.sss.practice.p06.entity.FruitsSeason;
import jp.co.sss.practice.p06.form.FruitsSeasonForm;
import jp.co.sss.practice.p06.repository.FruitsSeasonRepository;

@Controller
public class Practice0606Controller {
	@Autowired
	FruitsSeasonRepository fruitRepository;

	@GetMapping("/fruits/update")
	public String showSelectFruit(Model model) {
		model.addAttribute("fruitsList", fruitRepository.findAllByOrderByFruitIdAsc());
		return "practice06/06/fruit_select";
	}

	@PostMapping("/fruits/update/input")
	public String showFruitUpdateInput(Integer fruitId, Model model) {
		FruitsSeason fruit = fruitRepository.getReferenceById(fruitId);
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruit, fruitBean);
		model.addAttribute("fruit", fruitBean);
		return "practice06/06/fruit_input";
	}

	@PostMapping("/fruits/update/complete/{fruitId}")
	public String updateFruit(@PathVariable Integer fruitId, FruitsSeasonForm fruitForm, Model model) {
		FruitsSeason fruit = new FruitsSeason();
		BeanUtils.copyProperties(fruitForm, fruit);
		fruit = fruitRepository.save(fruit);
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruit, fruitBean);
		model.addAttribute("fruit", fruitBean);
		return "practice06/06/fruit_detail";
	}
}