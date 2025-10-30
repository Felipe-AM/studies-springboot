package io.github.felipe_am.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.felipe_am.webservices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
