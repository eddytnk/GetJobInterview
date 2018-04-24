package edu.mum.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.candidate.entity.Interest;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

}
