package com.teste.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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
	
	private String nomeUsuario;

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
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário deletado com sucesso."));
	}

	public void editarUsuario() {
		usuarioService.salvarUsuario(usuario);
		listarUsuarios();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário editado com sucesso."));
	}
	
	public void pesquisarUsuario() {
		this.listaUsuarios = usuarioService.pesquisarUsuarios(nomeUsuario);
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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
