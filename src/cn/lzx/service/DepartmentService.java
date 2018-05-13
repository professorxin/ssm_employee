package cn.lzx.service;

import java.util.List;

import cn.lzx.domin.Department;
import cn.lzx.domin.Page;

public interface DepartmentService {
	Page<Department> findByPage(Integer currPage);
	
	List<Department> findAll();
	
	Department findById(Integer did);
	
	void deleteDepartment(Integer did);
	
	void insertDepartment(Department department);
	
	void updateDepartment(Department department);
}
