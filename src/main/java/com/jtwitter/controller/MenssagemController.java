package com.jtwitter.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jtwitter.domain.mensagem.Mensagem;
import com.jtwitter.domain.mensagem.MensagemRepository;
import com.jtwitter.domain.usuario.Usuario;
import com.jtwitter.domain.usuario.UsuarioRepository;


@Controller
@RequestMapping("/mensagem")
public class MenssagemController {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepositor; 
	
	@GetMapping(path = "/nova")
	public String nova(Model model) {
		Mensagem mensagem = new Mensagem();
		model.addAttribute("mensagem", mensagem);
		
		
		//new Sort(Direction.ASC,"nome")
		List<Usuario>usuarios = usuarioRepositor.findAll();
		model.addAttribute("usuarios",usuarios);
		
		return "mensagem-criar";
	}
	
	@PostMapping(path = "/criar")
	public String criar(Mensagem mensagem) {
		if(!mensagem.getTexto().isEmpty()) {
			mensagem.setDataHora(LocalDateTime.now());
			mensagemRepository.save(mensagem);
			
		}
		return "";
	}
}
