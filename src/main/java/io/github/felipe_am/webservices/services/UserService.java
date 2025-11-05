package io.github.felipe_am.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.felipe_am.webservices.entities.User;
import io.github.felipe_am.webservices.repositories.UserRepository;
import io.github.felipe_am.webservices.services.exceptions.DatabaseException;
import io.github.felipe_am.webservices.services.exceptions.ResourceNotFoundException;

@Service //registro do componente no mecanismo de injeção para que o Autowired funcione
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){		
		return repository.findAll();		
	}
	
	public Optional<User> findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ResourceNotFoundException(id)));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
			} else {
				throw new ResourceNotFoundException(id);
			}
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}			
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}

}
