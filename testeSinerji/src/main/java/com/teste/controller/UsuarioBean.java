package com.teste.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.teste.entities.TipoSexo;
import com.teste.entities.Usuario;
import com.teste.services.UsuarioService;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	@Inject
	private UsuarioService usuarioService;

	public String salvarUsuario() {
		usuarioService.salvarUsuario(usuario);
		return "cadastroendereco";
	}

	public String excluirUsuario() {
		usuarioService.excluirUsuario(usuario);
		return "index";
	}

	@PostConstruct
	public void listarUsuarios() {
		listaUsuarios = usuarioService.exibirUsuarios();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public TipoSexo[] getTipoSexo() {
		return TipoSexo.values();
	}
}
