package edu.mum.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.candidate.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}