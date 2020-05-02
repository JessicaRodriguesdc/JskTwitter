package com.jtwitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mensagem")
public class MenssagemController {

	@GetMapping(path = "/nova")
	public String nova() {
		return "mensagem-criar";
	}
}
