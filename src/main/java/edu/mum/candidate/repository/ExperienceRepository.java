package edu.mum.candidate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;

import edu.mum.candidate.entity.Experience;



@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
	List<Experience> findByPosition(String position);
	//Candidate findById(ID id);

}
