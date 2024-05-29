package com.teste.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.teste.entities.Usuario;

public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public UsuarioRepository() {

	}

	public UsuarioRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<Usuario> exibirUsuarios() {
		String jpql = "from Usuario";
		return manager.createQuery(jpql, Usuario.class).getResultList();
	}

	public Usuario salvar(Usuario usuario) {
		return manager.merge(usuario);
	}

}