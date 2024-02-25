package ke.unify.jobapp.web.rest;

import ke.unify.jobapp.domain.Company;
import ke.unify.jobapp.repository.CompanyRepository;
import ke.unify.jobapp.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompanyResource {

    private final CompanyService companyService;
    private final CompanyRepository companyRepository;

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){

        Company result = companyService.save(company);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable("id") Long id, @RequestBody Company company){

        if (!Objects.equals(id, company.getId())){
            throw new IllegalArgumentException("Invalid ID supplied!");
        }

        if(!companyRepository.existsById(id)){
            throw new IllegalArgumentException(String.format("Company with id '%s' does not exists", id));
        }

        Company result = companyService.save(company);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll(){

        List<Company> companies = companyService.findAll();


        return ResponseEntity.ok().body(companies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> findById(@PathVariable("id") Long id){
        Optional<Company> result = companyService.findById(id);


        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        companyService.delete(id);
    }
}
