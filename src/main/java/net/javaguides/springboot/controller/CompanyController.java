package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/companys")
    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    /*
     * id */
    @GetMapping("/companys/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable(value = "id") Long companyId) throws ResourceNotFoundException {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("company not found for this id"));

        return ResponseEntity.ok(company);
    }

    /*
     * save */
    @PostMapping("/companys")
    public Company createDepartment(@RequestBody Company company) {
        return this.companyRepository.save(company);
    }

    /*
     * update */
    @PutMapping("/companys/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable(value = "id") Long companyId,
                                                       @Validated @RequestBody Company companyDetails) throws ResourceNotFoundException {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("company not found for this id"));

        company.setCompanyName(companyDetails.getCompanyName());

        return ResponseEntity.ok(this.companyRepository.save(company));
    }

    /*
     * delete */
    @DeleteMapping("companys/{id}")
    public Map<String,Boolean> deleteCompany(@PathVariable(value = "id") Long companyId) throws ResourceNotFoundException {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("company not found for this id"));

        this.companyRepository.delete(company);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);

        return response;
    }

}
