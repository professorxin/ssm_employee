package cn.lzx.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lzx.domin.Employee;
import cn.lzx.domin.Page;
import cn.lzx.service.EmployeeService;

public class EmployeeServiceTest extends BaseTest{
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void loginTest() {
		System.out.println(this);
		Employee employee=new Employee();
		employee.setUsername("zs");
		employee.setPassword("123");
		Employee existemployee=employeeService.login(employee);
		System.out.println(existemployee);
	}
	
	@Test
	public void findByPageTest() {
		Page<Employee> page=employeeService.findByPage(2);
		System.out.println(page);
	}
}
