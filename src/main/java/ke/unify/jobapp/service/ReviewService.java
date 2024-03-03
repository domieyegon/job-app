package ke.unify.jobapp.service;

import ke.unify.jobapp.domain.Company;
import ke.unify.jobapp.domain.Review;
import ke.unify.jobapp.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public Review save(Long companyId, Review review){

        Company company = companyService.findById(companyId).orElseThrow();

        review.setCompany(company);
        if (review.getId()== null){
            review.setCreatedAt(LocalDateTime.now());
        } else {
            review.setLastUpdatedAt(LocalDateTime.now());
        }
        return reviewRepository.save(review);
    }

    public List<Review> getByCompany(Long companyId){
        return reviewRepository.findByCompanyId(companyId);
    }
}
