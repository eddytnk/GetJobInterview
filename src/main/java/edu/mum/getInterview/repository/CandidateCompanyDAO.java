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
	
	public Long findCondidateCompanyCount(Candidate candidate, Company company) {

		TypedQuery<Long> query = 
				em.createQuery("select count(cc) from CandidateCompany cc JOIN cc.candidate cand "
						+ "JOIN cc.company comp WHERE cand.id =:cand AND comp.id =:com ",
				Long.class);

		query.setParameter("cand", candidate.getId());
		query.setParameter("com", company.getId());
		return query.getSingleResult();
	}
	
	public CandidateCompany findCondidateCompanyByResumeLink(String link) {
		TypedQuery<CandidateCompany> query = 
				em.createQuery("select cc from CandidateCompany cc WHERE cc.resumeLink =:link",
						CandidateCompany.class);

		query.setParameter("link", link);
		return query.getSingleResult();
	}

	public List<CandidateCompany> findByCompany(Company company) {

		TypedQuery<CandidateCompany> query = em.createQuery("select cc from CandidateCompany cc where cc.company = ?",
				CandidateCompany.class);

		query.setParameter(1, company);
		return query.getResultList();
	}
	
	

}
