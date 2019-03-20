package com.desalles.cursoinfinito;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desalles.cursoinfinito.domain.Categoria;
import com.desalles.cursoinfinito.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoInfinitoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoInfinitoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		/*
		 * categoriaRepository.save(Arrays.asList(cat1, cat2));
		 * 
		 * Esse comando não funciona no Spring 2.x.x devido ao Java 7
		 */
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
