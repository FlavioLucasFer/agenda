package br.ifpr.agenda.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpr.agenda.dominio.Usuario;
import br.ifpr.agenda.repositories.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;

	@PostMapping("/usuarios/salvar")
	public String salvarUsuario(@Valid Usuario usuario, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
			return "usuarios/editar";
		
		repository.save(usuario);

		return "redirect:/login";
	}
}
