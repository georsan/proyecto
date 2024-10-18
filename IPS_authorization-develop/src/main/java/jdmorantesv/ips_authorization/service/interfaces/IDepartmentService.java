package jdmorantesv.ips_authorization.service.interfaces;

import jdmorantesv.ips_authorization.model.Department;
import jdmorantesv.ips_authorization.request.DepartmentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDepartmentService {
    public List<Department> getAllDepartments();

    public Department getDepartmentById(Integer id);

    public Department addDepartment(DepartmentRequest departmentRequest);

    public Department updateDepartment(DepartmentRequest departmentRequest, Integer id);

    public Boolean deleteDepartment(Integer id);
}
