package edu.mum.getInterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.getInterview.entity.CandidateCompany;


public interface CandidateCompanyRepository extends JpaRepository<CandidateCompany, Long >{

}
