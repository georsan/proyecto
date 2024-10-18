package jdmorantesv.ips_authorization.repository;

import jdmorantesv.ips_authorization.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
}
