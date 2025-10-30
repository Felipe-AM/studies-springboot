package io.github.felipe_am.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.felipe_am.webservices.entities.Order;
import io.github.felipe_am.webservices.repositories.OrderRepository;

@Service //registro do componente no mecanismo de injeção para que o Autowired funcione
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){		
		return repository.findAll();		
	}
	
	public Optional<Order> findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj;
	}
		

}
