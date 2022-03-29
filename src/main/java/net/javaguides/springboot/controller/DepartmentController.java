package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.repository.CompanyRepository;
import net.javaguides.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/departments")
    public List<Department> findAll() {
        return this.departmentRepository.findAll();
    }

    /*
    * id */
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable(value = "id") Long departmentId) throws ResourceNotFoundException {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("department not found for this id"));

        return ResponseEntity.ok(department);
    }

    /*
    * save */
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department) {
        return this.departmentRepository.save(department);
    }

    /*
    * update */
    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Long departmentId,
                                                       @Validated @RequestBody Department departmentDetails) throws ResourceNotFoundException {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("department not found for this id"));

                department.setDepartmentName(departmentDetails.getDepartmentName());
                department.setIntroduced(departmentDetails.getIntroduced());

                return ResponseEntity.ok(this.departmentRepository.save(department));
    }

    /*
    * delete */
    @DeleteMapping("departments/{id}")
    public Map<String,Boolean> deleteDepartment(@PathVariable(value = "id") Long departmentId) throws ResourceNotFoundException {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("department not found for this id"));

        this.departmentRepository.delete(department);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);

        return response;
    }

}
