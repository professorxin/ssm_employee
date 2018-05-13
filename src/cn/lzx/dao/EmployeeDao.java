package cn.lzx.dao;

import java.util.List;
import java.util.Map;

import cn.lzx.domin.Employee;


public interface EmployeeDao {

	Employee findByNameAndPsw(Employee employee);
	
	Employee findByDid(Integer eid);
	
	List<Employee> selectAllEmployeeByPage(Map map);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(Integer eid);
	
	void insertEmployee(Employee employee);
}
