package cn.lzx.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lzx.controller.EmployeeController;
import cn.lzx.domin.Employee;

public class EmployeeControllerTest extends BaseTest{
	@Autowired
	private EmployeeController employeeController;
	
//	@Test
//	public void loginTest() {
//		Employee employee=new Employee();
//		employee.setUsername("zs");
//		employee.setPassword("123");
//		String a=employeeController.login(employee);
//		System.out.println(a);
//	}
	


}
