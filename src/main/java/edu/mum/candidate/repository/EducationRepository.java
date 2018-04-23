package edu.mum.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.candidate.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

}
