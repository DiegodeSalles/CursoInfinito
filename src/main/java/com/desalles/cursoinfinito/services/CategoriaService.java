package com.desalles.cursoinfinito.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desalles.cursoinfinito.domain.Categoria;
import com.desalles.cursoinfinito.repositories.CategoriaRepository;
import com.desalles.cursoinfinito.services.exceptions.ObjectNotFoundException;

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
		/*
		 * if(obj == null) { throw new
		 * ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " +
		 * Categoria.class.getName()); }
		 * 
		 * Não funciona na versão 2.x.x do Spring devido o Java 7
		 */
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
								"Objeto não encontrado! Id: " + id +
								", Tipo: " + Categoria.class.getName()));
	}
}
