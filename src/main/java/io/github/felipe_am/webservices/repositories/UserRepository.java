package io.github.felipe_am.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.felipe_am.webservices.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
