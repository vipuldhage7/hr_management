package com.hr.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hr.dao.IRegisterDao;
import com.hr.pojo.Candidate;

@EntityScan(basePackages = "com.hr.pojo")
@EnableJpaRepositories(basePackages = "com.hr.dao")
@SpringBootApplication
public class RegisterCandidatesApplication{

	public static void main(String[] args) {
		SpringApplication.run(RegisterCandidatesApplication.class, args);
	}

	
	 
}
