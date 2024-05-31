package com.teste.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	public Usuario buscarPorId(Long id) {
		return manager.find(Usuario.class, id);
	}
	
	public List<Usuario> buscarPorNome(String nomeUsuario){
		String jpql = "from Usuario where LOWER(nome) like LOWER(:nome)";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("nome", nomeUsuario + "%");
		return query.getResultList();
	}

	public void excluir(Usuario usuario) {
		usuario = buscarPorId(usuario.getId());
		manager.remove(usuario);
	}

}