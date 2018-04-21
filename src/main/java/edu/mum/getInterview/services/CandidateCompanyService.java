package edu.mum.getInterview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Candidate;
import edu.mum.company.entity.Company;
import edu.mum.getInterview.entity.CandidateCompany;
import edu.mum.getInterview.repository.CandidateCompanyDoa;
import edu.mum.getInterview.repository.CandidateCompanyRepository;

@Service
public class CandidateCompanyService {

	@Autowired
	private CandidateCompanyRepository candCompRepository;

	@Autowired
	private CandidateCompanyDoa candCompDao;

	public List<CandidateCompany> findByCandidate(Candidate candidate) {
		return candCompDao.findByCandidate(candidate);
	}

	public List<CandidateCompany> findByCandidate(Company company) {
		return candCompDao.findByCompany(company);
	}

	public void saveCandidateCompany(CandidateCompany candCompany) {
		candCompRepository.save(candCompany);
	}

	public void deleteCandidateCompany(CandidateCompany candCompany) {
		candCompRepository.delete(candCompany);
	}

}
