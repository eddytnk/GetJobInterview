package edu.mum.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.candidate.entity.Accomplishment;

@Repository
public interface AccomplishmentRepository extends JpaRepository<Accomplishment, Long> {

}
