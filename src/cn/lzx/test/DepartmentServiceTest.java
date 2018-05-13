package cn.lzx.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lzx.domin.Department;
import cn.lzx.domin.Page;
import cn.lzx.service.DepartmentService;

public class DepartmentServiceTest extends BaseTest{
	@Autowired
	private DepartmentService departmentService;
	
	@Test
	public void findByPageTest() {
		Page<Department> page=departmentService.findByPage(3);
		System.out.println(page);
	}
	
}
