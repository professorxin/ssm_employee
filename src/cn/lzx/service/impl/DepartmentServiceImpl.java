package cn.lzx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lzx.dao.DepartmentDao;
import cn.lzx.domin.Department;
import cn.lzx.domin.Page;
import cn.lzx.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	public DepartmentServiceImpl() {
		System.out.println("service被创建了");
	}
	
	@Autowired
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public Page<Department> findByPage(Integer currPage) {
		Page<Department> page=new Page<Department>(); 
		page.setCurrPage(currPage);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		List<Department> list=departmentDao.selectAllDepartmentByPage(map);
		page.setList(list);
		return page;
	}
	

	@Override
	public void deleteDepartment(Integer did) {
		departmentDao.deleteDepartment(did);
		
	}

	@Override
	public void insertDepartment(Department department) {
		departmentDao.insertDepartment(department);
		
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
		
	}



	@Override
	public Department findById(Integer did) {
		Department department=departmentDao.selectDepartmentById(did);
		return department;
	}

	@Override
	public List<Department> findAll() {
		List<Department> list=departmentDao.selectAllDepartment();
		return list;
	}
	
}
