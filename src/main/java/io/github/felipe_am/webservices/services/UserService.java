package io.github.felipe_am.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.felipe_am.webservices.entities.User;
import io.github.felipe_am.webservices.repositories.UserRepository;

@Service //registro do componente no mecanismo de injeção para que o Autowired funcione
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){		
		return repository.findAll();		
	}
	
	public Optional<User> findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj;
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
