package cn.lzx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lzx.domin.Department;
import cn.lzx.domin.Employee;
import cn.lzx.domin.Page;
import cn.lzx.service.DepartmentService;
import cn.lzx.service.EmployeeService;

@Controller
@RequestMapping("/Employee")
public class EmployeeController{
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@Autowired
	private DepartmentService departmentService;
	
/*	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}*/
	

	@RequestMapping("/login")
	public String login(Employee employee,HttpSession session) {
		System.out.println(employee.getUsername()+"---"+employee.getPassword());
		Employee existemployee=employeeService.login(employee);
		if(existemployee!=null) {
			session.setAttribute("existemployee",existemployee);
			return "/frame.jsp";
		}
		else {
			return "/index.jsp";
		}
	}
	
	
	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request,ModelMap model) {
		Integer currPage=1;
		if(request.getParameter("currPage")!=null) {
			currPage=Integer.parseInt(request.getParameter("currPage"));
		}
		Page<Employee> page=employeeService.findByPage(currPage);
		model.addAttribute("page", page);
		return "/frame/listEmployee.jsp";
	}
	
	@RequestMapping("/save")
	public String save(ModelMap map) {
		List<Department> list=departmentService.findAll();
		map.addAttribute("list",list);
		return "/frame/addEmployee.jsp";
	}
	
	@RequestMapping("/insert")
	public String insert(Employee employee) {
		System.out.println("插入员工"+employee);
		employeeService.insertEmployee(employee);
		return "redirect:/Employee/findAll";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Integer eid=Integer.parseInt(request.getParameter("eid"));
		employeeService.deleteEmployee(eid);
		return "redirect:/Employee/findAll";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,ModelMap map) {
		Integer eid=Integer.parseInt(request.getParameter("eid"));
		Employee employee=employeeService.findById(eid);
		List<Department> list=departmentService.findAll();
		map.addAttribute("list",list);
		map.addAttribute("employee",employee);
		return "/frame/editEmployee.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Employee employee) {
		System.out.println("更新员工"+employee);
		employeeService.updateEmployee(employee);
		return "redirect:/Employee/findAll";
	}
}
