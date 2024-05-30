package com.teste.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.teste.entities.Endereco;
import com.teste.repositories.EnderecoRepository;
import com.teste.utils.Transactional;

public class EnderecoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoRepository enderecoRepository;

	@Transactional
	public Endereco salvarEndereco(Endereco endereco) {
		return enderecoRepository.salvar(endereco);
	}

	@Transactional
	public void excluirUsuario(Endereco endereco) {
		enderecoRepository.excluir(endereco);
	}

}
