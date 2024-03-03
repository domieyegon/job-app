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

        return ResponseEntity.ok().body(reviewService.getByCompany(companyId));
    }
}
