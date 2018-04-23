package edu.mum.getInterview.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.candidate.entity.Candidate;
import edu.mum.company.entity.Company;
import edu.mum.getInterview.entity.CandidateCompany;

@Repository
@Transactional
public class CandidateCompanyDAO {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CandidateCompanyRepository repository;

	public List<CandidateCompany> findByCandidate(Candidate candidate) {

		TypedQuery<CandidateCompany> query = em.createQuery("select cc from CandidateCompany cc where cc.candidate = ?",
				CandidateCompany.class);

		query.setParameter(1, candidate);
		return query.getResultList();
	}

	public List<CandidateCompany> findByCompany(Company company) {

		TypedQuery<CandidateCompany> query = em.createQuery("select cc from CandidateCompany cc where cc.company = ?",
				CandidateCompany.class);

		query.setParameter(1, company);
		return query.getResultList();
	}
	
	

}
