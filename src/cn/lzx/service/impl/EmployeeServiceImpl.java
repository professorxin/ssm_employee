package cn.lzx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lzx.dao.EmployeeDao;
import cn.lzx.domin.Employee;
import cn.lzx.domin.Page;
import cn.lzx.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
/*	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
*/


	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existemployee=employeeDao.findByNameAndPsw(employee);
		return existemployee;
	}

	@Override
	public Page<Employee> findByPage(Integer currPage) {
		Page<Employee> page=new Page<>();
		page.setCurrPage(currPage);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		List<Employee> list=employeeDao.selectAllEmployeeByPage(map);
		page.setList(list);
		return page;
	}

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(Integer eid) {
		employeeDao.deleteEmployee(eid);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		Employee employee=employeeDao.findByDid(eid);
		return employee;
	}
	


}
