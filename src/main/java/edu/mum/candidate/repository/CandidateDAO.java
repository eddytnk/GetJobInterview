package edu.mum.candidate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.candidate.entity.Candidate;


@Repository
@Transactional
public class CandidateDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CandidateRepository repository;
	
	public List<Candidate> findByName(String name){		
		TypedQuery<Candidate> query = em.createQuery("select c from Candidate c where c.name = ?",Candidate.class);
		query.setParameter(1, name);
		return query.getResultList();
		
	}
	
	public List<Candidate> findByEmailAddress(String emailAddress){		
		TypedQuery<Candidate> query = em.createQuery("select c from Candidate c where c.emailAddress = ?",Candidate.class);
		query.setParameter(1, emailAddress);
		return query.getResultList();
		
	}
	
	

}
