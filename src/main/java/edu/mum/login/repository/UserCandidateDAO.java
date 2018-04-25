package edu.mum.login.repository;

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
public class UserCandidateDAO {
	@PersistenceContext
	private EntityManager em;

	
	public Candidate findUserId(Long userID){	
		TypedQuery<Candidate> query = em.createQuery(" select c.candidate from UserCandidate c where c.user.id =:userID ", Candidate.class); 
		query.setParameter("userID", userID);
		return query.getSingleResult();
	}
	

}
