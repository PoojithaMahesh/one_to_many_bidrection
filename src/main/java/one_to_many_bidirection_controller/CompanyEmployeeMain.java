package one_to_many_bidirection_controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_bidirection.Company;
import one_to_many_bidirection.Employee;
import one_to_many_bidirection_dao.Employeedao;

public class CompanyEmployeeMain {
public static void main(String[] args) {
	Employee employee1=new Employee();
	employee1.setId(10);
	employee1.setName("poo");
	employee1.setPhone(789);
	Employee employee2 =new Employee();
	employee2.setId(2);
	employee2.setName("pooji");
	employee2.setPhone(7988);	
	Employee employee3=new Employee();
	employee3.setId(4);
	employee3.setName("poojith");
	employee3.setPhone(8888);
	List<Employee> list=new ArrayList<Employee>();
	list.add(employee1);
	list.add(employee2);
	list.add(employee3);
	
	
	Company company=new Company();
	company.setGst("gst123");
	company.setId(1001);
	company.setName("ty");
	company.setEmployee(list);
	
	employee1.setCompany(company);
	employee2.setCompany(company);
	employee3.setCompany(company);
//	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
//	EntityManager entityManager=entityManagerFactory.createEntityManager();
//	EntityTransaction entityTransaction=entityManager.getTransaction();
//	entityTransaction.begin();
//	entityManager.persist(company);
//	entityManager.persist(employee1);
//	entityManager.persist(employee2);
//	entityManager.persist(employee3);
//	entityTransaction.commit();
	Employeedao employeedao=new Employeedao();
	employeedao.saveEmployee(101,employee1);
	
	
}
}
