package io.github.felipe_am.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.felipe_am.webservices.entities.OrderItem;
import io.github.felipe_am.webservices.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
