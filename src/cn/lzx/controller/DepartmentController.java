package cn.lzx.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lzx.domin.Department;
import cn.lzx.domin.Page;
import cn.lzx.service.DepartmentService;

@Controller
@RequestMapping("/Department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request,ModelMap model) {
		Integer currPage=1;
		if(request.getParameter("currPage")!=null) {
			currPage=Integer.parseInt(request.getParameter("currPage"));
		}
		Page<Department> page=departmentService.findByPage(currPage);
		System.out.println(page);
		model.addAttribute("page", page);
		return "/frame/list.jsp";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,ModelMap map) {
		Integer did=Integer.parseInt(request.getParameter("did"));
		Department department=departmentService.findById(did);
		map.addAttribute("department",department);
		return "/frame/editDepartment.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Department department) {
		departmentService.updateDepartment(department);
		//重定向
		return "redirect:/Department/findAll";
	}
	
	@RequestMapping("/save")
	public String save() {
		return "/frame/addDepartment.jsp";
	}
	
	@RequestMapping("/insert")
	public String insert(Department department) {
		departmentService.insertDepartment(department);
		return "redirect:/Department/findAll";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Integer eid=Integer.parseInt(request.getParameter("did"));
		departmentService.deleteDepartment(eid);
		return "redirect:/Department/findAll";
	}
	
}
