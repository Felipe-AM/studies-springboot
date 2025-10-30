package io.github.felipe_am.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.felipe_am.webservices.entities.Product;
import io.github.felipe_am.webservices.repositories.ProductRepository;

@Service //registro do componente no mecanismo de injeção para que o Autowired funcione
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){		
		return repository.findAll();		
	}
	
	public Optional<Product> findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj;
	}
		

}
