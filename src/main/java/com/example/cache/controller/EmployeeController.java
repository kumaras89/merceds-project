package com.example.cache.controller;

import com.example.cache.dao.EmployeeRepo;
import com.example.cache.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class EmployeeController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EmployeeRepo eRepo;

    @Cacheable(value = "emps", key="#id")
    @GetMapping("/employees/{id}")
    @Transactional
    public Employee getEmployee(@PathVariable Integer id) {
        log.info("Getting employee with ID {}.", id);
        Optional<Employee> byId = eRepo.findById(id);
//        Employee e = new Employee(new Random().nextInt(), "kumar");
        return byId.get();
    }

    @Cacheable(value = "emps", key="#name")
    @GetMapping("/employees-nmae/{name}")
    @Transactional
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        log.info("Getting employee with Name {}.", name);
        List<Employee> empName = eRepo.findByName(name);
//        Employee e = new Employee(new Random().nextInt(), "kumar");
        return empName;
    }

    @Cacheable(value = "emps", key="#e.id")
    @PostMapping("/employees")
    @Transactional
    public Employee create(@RequestBody Employee e) {
        log.info("Creating employee with Name {}.", e);
        Employee emp = eRepo.save(e);
//        Employee e = new Employee(new Random().nextInt(), "kumar");
        return emp;
    }

    @CacheEvict(value = "emps", key = "#id")
    @DeleteMapping("/{id}")
    public void deleteEmployeeByID(@PathVariable Integer id) {
        log.info("deleting employee with id {}", id);

    }

    @Cacheable(value = "newE")
    @GetMapping("/employees")
    @Transactional
    public List<Employee> getAllEmployee() {
        log.info("Getting employee ");
        List<Employee> all = eRepo.findAll();
//        Employee e = new Employee(new Random().nextInt(), "kumar");
        return all;
    }

}
