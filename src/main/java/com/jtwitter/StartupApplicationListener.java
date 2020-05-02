package com.jtwitter;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jtwitter.domain.mensagem.Mensagem;
import com.jtwitter.domain.mensagem.MensagemRepository;
import com.jtwitter.domain.usuario.Usuario;
import com.jtwitter.domain.usuario.UsuarioRepository;

@Component
public class StartupApplicationListener {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
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
		
		
		Mensagem m1_u1 = new Mensagem();
		m1_u1.setDataHora(LocalDateTime.now().minusMinutes(45));
		m1_u1.setTexto("O Java ainda tem vida longa, apesar de alguns dizerem que não");
		m1_u1.setUsuario(u1);
		mensagemRepository.save(m1_u1);
		
		
		Mensagem m2_u1 = new Mensagem();
		m2_u1.setDataHora(LocalDateTime.now().minusMinutes(42));
		m2_u1.setTexto("FATO: No mercado de trabalho o que mais tem vaga pra trabalhar com Java");
		m2_u1.setUsuario(u1);
		mensagemRepository.save(m2_u1);
		
		
		Mensagem m1_u2 = new Mensagem();
		m1_u2.setDataHora(LocalDateTime.now().minusMinutes(27));
		m1_u2.setTexto("Olha que sistema show esse, e simples de fazer");
		m1_u2.setUsuario(u2);
		mensagemRepository.save(m1_u2);
		
		
		Mensagem m2_u2 = new Mensagem();
		m2_u2.setDataHora(LocalDateTime.now().minusMinutes(22));
		m2_u2.setTexto("Estou tão impresionado que estou com vontade de contar uma piada");
		m2_u2.setUsuario(u2);
		mensagemRepository.save(m2_u2);
		
		Mensagem m3_u2 = new Mensagem();
		m3_u2.setDataHora(LocalDateTime.now().minusMinutes(20));
		m3_u2.setTexto("Puuttzz :P");
		m3_u2.setUsuario(u2);
		mensagemRepository.save(m3_u2);
	}
}
