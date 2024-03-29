package ke.unify.jobapp.web.rest;

import ke.unify.jobapp.domain.Company;
import ke.unify.jobapp.domain.Review;
import ke.unify.jobapp.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies/{companyId}")
@AllArgsConstructor
public class ReviewResource {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<Review> addReview(@PathVariable Long companyId, @RequestBody Review review){
        return ResponseEntity.ok().body(reviewService.save(companyId, review));
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable(name = "companyId") Long companyId){

        return ResponseEntity.ok().body(reviewService.getByCompanyId(companyId));
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable(name = "companyId") Long companyId, @PathVariable(name = "id") Long id){

        return ResponseEntity.ok().body(reviewService.getByCompanyIdAndId(companyId, id));
    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable(name = "companyId") Long companyId, @PathVariable(name = "id") Long id){
        reviewService.deleteReview(companyId,  id);
    }
}
