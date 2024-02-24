package ke.unify.jobapp.web.rest;

import ke.unify.jobapp.JobService;
import ke.unify.jobapp.domain.Job;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
@AllArgsConstructor
public class JobResource {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job){

        Job result = jobService.save(job);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable("id") Long id, @RequestBody Job job){

        Job result = jobService.save(job);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){

        List<Job> jobs = jobService.findAll();


        return ResponseEntity.ok().body(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Job>> findById(@PathVariable("id") Long id){
        Optional<Job> result = jobService.findById(id);


        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable("id") Long id){
        jobService.delete(id);
    }
}
