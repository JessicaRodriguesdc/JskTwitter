package com.jtwitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jtwitter.domain.usuario.Usuario;
import com.jtwitter.domain.usuario.UsuarioRepository;

@Component
public class StartupApplicationListener {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@EventListener
	public void onAplicationEvent(ContextRefreshedEvent event) {
		Usuario u1 = new Usuario();
		u1.setId("jsk");
		u1.setNome("Jéssica");
		
		usuarioRepository.save(u1);
		
		Usuario u2 = new Usuario();
		u2.setId("emy");
		u2.setNome("Emily");
		
		usuarioRepository.save(u2);
	}
}
