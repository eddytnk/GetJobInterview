package edu.mum.getInterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.candidate.entity.Candidate;
import edu.mum.getInterview.entity.CandidateCompany;


public interface CandidateCompanyRepository extends JpaRepository<CandidateCompany, Long >{

	List<CandidateCompany> findCandidateCompanyByCandidate(Candidate candidaate);
}
