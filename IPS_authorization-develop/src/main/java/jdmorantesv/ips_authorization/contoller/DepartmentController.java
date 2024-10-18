package jdmorantesv.ips_authorization.contoller;

import jdmorantesv.ips_authorization.model.Department;
import jdmorantesv.ips_authorization.request.DepartmentRequest;
import jdmorantesv.ips_authorization.service.impl.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping("create")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return ResponseEntity.ok(departmentService.addDepartment(departmentRequest));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Department> editDepartment(@PathVariable Integer id, @RequestBody DepartmentRequest departmentRequest) {
        return ResponseEntity.ok(departmentService.updateDepartment(departmentRequest, id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }
}
