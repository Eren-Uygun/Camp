package com.etiya.rentACar.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.entities.Color;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {
	
	@GetMapping("/getColors")
	public List<Color> getColors(){
		List<Color> colors = new ArrayList<Color>();
		colors.add(new Color(1,"Sarı"));
		colors.add(new Color(2,"Kırmızı"));
		colors.add(new Color(3,"Turuncu"));
		colors.add(new Color(4,"Beyaz"));
		return colors;
		
	}

}