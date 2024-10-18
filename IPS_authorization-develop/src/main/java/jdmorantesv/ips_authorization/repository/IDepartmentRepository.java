package jdmorantesv.ips_authorization.repository;

import jdmorantesv.ips_authorization.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
