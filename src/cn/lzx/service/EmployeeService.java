package cn.lzx.service;

import cn.lzx.domin.Employee;
import cn.lzx.domin.Page;

public interface EmployeeService {

	Employee login(Employee employee);
	
	Employee findById(Integer eid);
	
	Page<Employee> findByPage(Integer currPage);
	
	void insertEmployee(Employee employee);
	
	void deleteEmployee(Integer eid);
	
	void updateEmployee(Employee employee);
}
