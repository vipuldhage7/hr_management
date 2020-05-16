package com.hr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hr.pojo.Candidate;

@Repository
public interface IRegisterDao extends JpaRepository<Candidate, Long>{

	Candidate findByName(String name);
	
	@Query("select c from Candidate c where c.experience=:experience and c.skills=:skills")
	Candidate findByExpAndSkills(@Param("experience") Float experience, @Param("skills") String skills);
}
