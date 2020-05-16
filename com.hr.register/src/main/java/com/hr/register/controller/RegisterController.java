package com.hr.register.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.dao.IRegisterDao;
import com.hr.pojo.Candidate;

@RestController
public class RegisterController {

	@Autowired
	IRegisterDao regDao;

	@GetMapping("/getCandidates")
	public List<Candidate> getCandidates() {

		List<Candidate> listOfCandidates = regDao.findAll();

		listOfCandidates.forEach(x -> {
			System.out.println(x.getName() + " " + x.getExperience() + " " + x.getSkills() + " " + x.getLocation());
		});

		return listOfCandidates;
	}

	@GetMapping(value = "/getSepcificCandidates")
	public Candidate getSepcificCandidates(@RequestParam String candidateName) {
		System.out.println("Inside /getSepcificCandidates:: " + candidateName);
		Candidate candidate = regDao.findByName(candidateName);

		Optional<Candidate> optCandidate = Optional.ofNullable(candidate);
		System.out.println(optCandidate);

		if (optCandidate.isPresent()) {
			return candidate;
		} else {
			return null;
		}

	}

	@PostMapping(value = "/getCandidateBySkill")
	public Candidate getCandidateBySkill(@RequestParam String skills, @RequestParam String exp) {

		Float floatExp = Float.parseFloat(exp);
		System.out.println("Experience in float:: " + floatExp);
		Candidate candidate = regDao.findByExpAndSkills(floatExp, skills);

		Optional<Candidate> optCandidate = Optional.ofNullable(candidate);
		System.out.println(optCandidate);

		if (optCandidate.isPresent()) {
			return candidate;
		} else {
			return null;
		}
	}

	@PostMapping(value = "/saveCandidate")
	public List<Candidate> saveCandidate(@RequestBody Candidate candidate) {

		Candidate savedCandidate = regDao.save(candidate);

		System.out.println("Inside saveCandidate:: " + savedCandidate);
		List<Candidate> listOfCandidates = regDao.findAll();

		listOfCandidates.forEach(x -> {
			System.out.println(x.getName() + " " + x.getExperience() + " " + x.getSkills() + " " + x.getLocation());
		});

		return listOfCandidates;
	}
	
	@PostMapping(value = "/updateCandidate")
	public String updateCandidate(@RequestParam String id) {

		Long londId = Long.parseLong(id);
		System.out.println("Inside :: updateCandidate() ");
		String activeFlag = "N";
		Integer status = regDao.updateById(londId,activeFlag);

		Optional<Integer> optStatus = Optional.ofNullable(status);

		if (optStatus.isPresent()) {
			return "Record Deleted Successfully";
		} else {
			return null;
		}
	
	}
	

}
