package com.example.cache;

import com.example.cache.controller.EmployeeController;
import com.example.cache.dao.EmployeeRepo;
import com.example.cache.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Collection;
import java.util.Map;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
@EnableScheduling
public class CacheApplication  implements CommandLineRunner {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private final EmployeeRepo empRepo;

	@Autowired
	public CacheApplication(EmployeeRepo empRepo) {
		this.empRepo = empRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		empRepo.save(new Employee(1,"Kumar"));
		empRepo.save(new Employee(2,"Ram"));
		empRepo.save(new Employee(3,"Kuram"));
		empRepo.save(new Employee(4,"Ragavan"));
		log.info("emps:",empRepo.findAll());
	}

}

