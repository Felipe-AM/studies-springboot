package io.github.felipe_am.webservices.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.felipe_am.webservices.entities.Category;
import io.github.felipe_am.webservices.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){			
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}") // indica que a requisição vai aceitar um id dentro da url, usado em conjunto com o @PathVariable
	public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
		Optional<Category> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
	
}
