package com.desalles.cursoinfinito.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desalles.cursoinfinito.domain.Categoria;
import com.desalles.cursoinfinito.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	/*
	 * public Categoria buscar(Integer id) {
	 * 
	 * Categoria obj = repo.getOne(id); return obj; 
	 * 
	 * }
	 * 
	 * Não funciona na versão 2.x.x do Spring por causa do Java 7 não ser mais utilizado pelo mesmo.
	 */
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
