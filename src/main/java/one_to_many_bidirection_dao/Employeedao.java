package one_to_many_bidirection_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_bidirection.Company;
import one_to_many_bidirection.Employee;

public class Employeedao {
public EntityManager getEntityManager() {
	EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("vinod");
	return entityManagerFactory.createEntityManager();
	
}
public void saveEmployee(int id,Employee employee) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Company company=entityManager.find(Company.class, id);
	entityTransaction.begin();
	employee.setCompany(company);
	entityManager.persist(employee);
	entityTransaction.commit();
}
public void updateEmployee(int id,Employee employee) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Employee employee2=entityManager.find(Employee.class, id);
	if(employee2!=null) {
	entityTransaction.begin();
	employee.setId(id);
	entityManager.merge(employee);
	entityTransaction.commit();
	}else {
		System.out.println("employe is not present");
	}
}
public void deleteEmployee(int id) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Employee employee=entityManager.find(Employee.class, id);
	entityTransaction.begin();
	entityManager.remove(employee);
	entityTransaction.commit();
	
}
public void getEmployeeById(int id) {
	EntityManager entityManager=getEntityManager();
	Employee employee=entityManager.find(Employee.class, id);
	System.out.println(employee);
}
public void getAllEmployee() {
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select e from Employee e ");
	List<Employee> list=query.getResultList();
	System.out.println(list);
	
}
}
