package jdmorantesv.ips_authorization.service.impl;

import jdmorantesv.ips_authorization.exception.ResourceNotFoundException;
import jdmorantesv.ips_authorization.model.Department;
import jdmorantesv.ips_authorization.repository.IDepartmentRepository;
import jdmorantesv.ips_authorization.request.DepartmentRequest;
import jdmorantesv.ips_authorization.service.interfaces.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService  implements IDepartmentService {
    @Autowired
    private final IDepartmentRepository departmentRepository;
    @Override
    public Department getDepartmentById(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        }else{
            throw new ResourceNotFoundException("Department with id " + id + " not found");
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    @Override
    public Department addDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setName(departmentRequest.getName());
        departmentRepository.save(department);
        return department;
    }
    @Override
    public Department updateDepartment(DepartmentRequest departmentRequest, Integer departmentId) {
        // Buscar el departamento por ID
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            // Actualizar los campos necesarios
            department.setName(departmentRequest.getName());
            // Guardar los cambios
            departmentRepository.save(department);
            return department;
        } else {
            // Manejar el caso donde el departamento no existe
            throw new ResourceNotFoundException("Department not found with id: " + departmentId);
        }

    }
    @Override
    public Boolean deleteDepartment(Integer id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            departmentRepository.delete(optionalDepartment.get());
            return true;
        }else {
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }
    }
}
