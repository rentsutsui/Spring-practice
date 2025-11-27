package jp.co.sss.practice.p07.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p07.entity.Area;
import jp.co.sss.practice.p07.repository.AreaRepository;
import jp.co.sss.practice.p07.repository.FruitsAreaRepository;

@Controller
public class Practice0702Controller {
	
	@Autowired
	FruitsAreaRepository fruitsRepository;
	
	@Autowired
	AreaRepository areaRepository;

	@GetMapping("/fruits/select/area")
	public String showSelectArea(Model model) {
		model.addAttribute("areaList", areaRepository.findAllByOrderByAreaId());
		return "practice07/02/area_select";
	}
	
	@GetMapping("/fruits/select/area/result")
	public String seachFruitsByArea(Integer areaId ,Model model) {
		Area area = areaRepository.getReferenceById(areaId);
		model.addAttribute("fruitsList", fruitsRepository.findByAreaOrderByFruitId(area));
		model.addAttribute("areaName", area.getAreaName());
		return "practice07/02/fruits_list";
	
	}
}
