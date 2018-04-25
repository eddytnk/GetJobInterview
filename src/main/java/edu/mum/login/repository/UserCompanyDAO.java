package edu.mum.login.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.company.entity.Company;


@Repository
@Transactional
public class UserCompanyDAO {
	@PersistenceContext
	private EntityManager em;

	
	public Company findByUserId(Long userID){	
		TypedQuery<Company> query = em.createQuery(" select c.company from UserCompany c where c.user.id =:userID ", Company.class); 
		query.setParameter("userID", userID);
		return query.getSingleResult();
	}
	

}
