package io.github.felipe_am.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.felipe_am.webservices.entities.Category;
import io.github.felipe_am.webservices.repositories.CategoryRepository;

@Service //registro do componente no mecanismo de injeção para que o Autowired funcione
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){		
		return repository.findAll();		
	}
	
	public Optional<Category> findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj;
	}
		

}
