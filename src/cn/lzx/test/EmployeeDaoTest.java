package cn.lzx.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lzx.dao.EmployeeDao;
import cn.lzx.domin.Employee;

public class EmployeeDaoTest extends BaseTest {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Test
	public void TestFindByNameAndPsw() throws Exception{
		Employee employee=new Employee();
		employee.setUsername("zs");
		employee.setPassword("123");
		Employee existemployee=employeeDao.findByNameAndPsw(employee);
		System.out.println(existemployee);
	}
}
