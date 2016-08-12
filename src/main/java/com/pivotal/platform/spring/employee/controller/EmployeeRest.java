package com.pivotal.platform.spring.employee.controller;

import com.pivotal.platform.spring.employee.domain.Employee;
import com.pivotal.platform.spring.employee.repository.EmployeeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRest
{
    private static Log logger = LogFactory.getLog(EmployeeRest.class);
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRest(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public List<Employee> listEmployees()
    {
        List<Employee> emps = employeeRepository.findAll();

        return emps;
    }

    @RequestMapping(value = "/emp/{empid}", method = RequestMethod.GET)
    public Employee findEmployee(@PathVariable String empid)
    {
        Employee emp = employeeRepository.findOne(new Long(empid));

        return emp;
    }

    @RequestMapping(value = "/empwithjob/{job}", method = RequestMethod.GET)
    public List<Employee> findEmployeeByJob(@PathVariable String job)
    {
        List<Employee> emp = employeeRepository.findByJob(job.toUpperCase());

        return emp;
    }
}
