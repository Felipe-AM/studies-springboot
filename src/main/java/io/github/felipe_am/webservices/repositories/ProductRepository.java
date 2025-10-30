package io.github.felipe_am.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.felipe_am.webservices.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
