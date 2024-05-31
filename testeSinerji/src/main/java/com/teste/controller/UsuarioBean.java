package com.teste.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.teste.services.EnderecoService;
import com.teste.entities.Endereco;
import com.teste.entities.TipoSexo;
import com.teste.entities.Usuario;
import com.teste.services.UsuarioService;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;

	@Inject
	private Endereco endereco;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private EnderecoService enderecoService;

	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	public String salvarUsuario() {
		endereco.setUsuario(usuario);
		enderecoService.salvarEndereco(endereco);
		listarUsuarios();
		return "index?faces-redirect=true";
	}

	@PostConstruct
	public void listarUsuarios() {
		this.listaUsuarios = usuarioService.exibirUsuarios();
	}

	public void excluirUsuario() {
		usuarioService.excluirUsuario(usuario);
		listarUsuarios();
	}
	
	public void editarUsuario() {
		usuarioService.salvarUsuario(usuario);
		listarUsuarios();
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

	public boolean isUsuarioSelecionado() {
		return usuario != null && usuario.getId() != null;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
