package br.com.noemi.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.noemi.curso.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
