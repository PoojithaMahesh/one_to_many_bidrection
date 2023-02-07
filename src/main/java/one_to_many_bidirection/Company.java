package one_to_many_bidirection;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
private int id;
private String name;
private String gst;
@OneToMany(mappedBy = "company")
private List<Employee> employee;

public List<Employee> getEmployee() {
	return employee;
}
public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGst() {
	return gst;
}
public void setGst(String gst) {
	this.gst = gst;
}



}
