package com.teste.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.teste.entities.Usuario;
import com.teste.repositories.UsuarioRepository;
import com.teste.utils.Transactional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.salvar(usuario);
	}

	@Transactional
	public List<Usuario> exibirUsuarios() {
		return usuarioRepository.exibirUsuarios();
	}
	
	@Transactional
	public List<Usuario> pesquisarUsuarios(String nome) {
		return usuarioRepository.buscarPorNome(nome);
	}

	@Transactional
	public void excluirUsuario(Usuario usuario) {
		usuarioRepository.excluir(usuario);
	}
}
