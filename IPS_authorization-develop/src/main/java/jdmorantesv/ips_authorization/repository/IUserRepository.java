package jdmorantesv.ips_authorization.repository;

import jdmorantesv.ips_authorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
        Optional<User> findByUsername(String username);

}
