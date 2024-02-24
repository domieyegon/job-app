package ke.unify.jobapp;

import ke.unify.jobapp.domain.Job;
import ke.unify.jobapp.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public Job save(Job job){
        if (job.getId() == null){
            job.setPostedOn(LocalDateTime.now());
        } else {
            job.setLastUpdatedOn(LocalDateTime.now());
        }
        return jobRepository.save(job);
    }

    public List<Job> findAll(){
        return jobRepository.findAll();
    }

    public Optional<Job> findById(Long id){
        return jobRepository.findById(id);
    }

    public void delete(Long id){
        jobRepository.deleteById(id);
    }

}
