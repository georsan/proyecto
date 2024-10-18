package jdmorantesv.ips_authorization.repository;

import jdmorantesv.ips_authorization.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Integer> {
}
