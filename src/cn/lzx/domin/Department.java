package cn.lzx.domin;

import java.util.List;

public class Department {
	private Integer did;
	private String dname;
	private String ddesc;
	private List<Employee> employee;
	
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", ddesc=" + ddesc + ", employee=" + employee + "]";
	}

	
	
	
}
