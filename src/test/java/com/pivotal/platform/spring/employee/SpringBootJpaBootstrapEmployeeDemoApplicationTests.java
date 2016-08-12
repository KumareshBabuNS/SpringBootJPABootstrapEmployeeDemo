package com.pivotal.platform.spring.employee;

import com.pivotal.platform.spring.employee.domain.Employee;
import com.pivotal.platform.spring.employee.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaBootstrapEmployeeDemoApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void testEmployeeCount()
	{
		Assert.assertEquals(13, employeeRepository.count());
	}

	@Test
	public void testEmployeeFound()
	{
		Employee emp = employeeRepository.findOne(new Long(1));
		Assert.assertNotNull(emp);
	}

	@Test
	public void contextLoads() {
	}

}
