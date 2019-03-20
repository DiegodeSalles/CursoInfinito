package com.desalles.cursoinfinito.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desalles.cursoinfinito.domain.Pedido;
import com.desalles.cursoinfinito.repositories.PedidoRepository;
import com.desalles.cursoinfinito.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	/*
	 * public Pedido buscar(Integer id) {
	 * 
	 * Pedido obj = repo.getOne(id); return obj; 
	 * 
	 * }
	 * 
	 * Não funciona na versão 2.x.x do Spring por causa do Java 7 não ser mais utilizado pelo mesmo.
	 */
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		/*
		 * if(obj == null) { throw new
		 * ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " +
		 * Pedido.class.getName()); }
		 * 
		 * Não funciona na versão 2.x.x do Spring devido o Java 7
		 */
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
								"Objeto não encontrado! Id: " + id +
								", Tipo: " + Pedido.class.getName()));
	}
}
