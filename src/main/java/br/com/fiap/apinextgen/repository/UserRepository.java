package br.com.fiap.apinextgen.repository;

import br.com.fiap.apinextgen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
