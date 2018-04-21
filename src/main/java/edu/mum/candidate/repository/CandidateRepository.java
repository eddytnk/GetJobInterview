package edu.mum.candidate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;

import edu.mum.candidate.entity.Candidate;



@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>{
	List<Candidate> findByName(String name);

}
