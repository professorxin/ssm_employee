package cn.lzx.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lzx.dao.DepartmentDao;
import cn.lzx.domin.Department;
import cn.lzx.domin.Page;

public class DepartmentDaoTest extends BaseTest{
	@Autowired
	private DepartmentDao departmentDao;
	
	@Test
	public void testSelectAllDepartment() throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		Page page=new Page(9,2,3,3,3,3); 
		map.put("page", page);
		System.out.println(departmentDao);
		List<Department> list=departmentDao.selectAllDepartmentByPage(map);
		System.out.println(list);
	}
}
