package ke.unify.jobapp.repository;

import ke.unify.jobapp.domain.Company;
import ke.unify.jobapp.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByCompanyId(Long companyId);
    Optional<Review> findByCompanyIdAndId(Long companyId, Long id);
    void deleteByCompanyIdAndId(Long companyId, Long id);
}
