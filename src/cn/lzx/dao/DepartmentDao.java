package cn.lzx.dao;

import java.util.List;
import java.util.Map;

import cn.lzx.domin.Department;


public interface DepartmentDao {
	Department selectDepartmentById(Integer did);
	
	List<Department> selectAllDepartment();
	
	List<Department> selectAllDepartmentByPage(Map map);
	
	void deleteDepartment(Integer did);
	
	void insertDepartment(Department department);
	
	void updateDepartment(Department department);
}
