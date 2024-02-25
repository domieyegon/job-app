package ke.unify.jobapp.service;

import ke.unify.jobapp.domain.Company;
import ke.unify.jobapp.domain.Job;
import ke.unify.jobapp.repository.CompanyRepository;
import ke.unify.jobapp.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company save(Company company){
        if (company.getId() == null){
            company.setCreatedAt(LocalDateTime.now());
        } else {
            company.setLastUpdatedAt(LocalDateTime.now());
        }
        return companyRepository.save(company);
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Optional<Company> findById(Long id){
        return companyRepository.findById(id);
    }

    public void delete(Long id){
        companyRepository.deleteById(id);
    }

}
