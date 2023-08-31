package org.ncu.fsb_demo_jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.ncu.fsb_demo_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insertRecord(Employee emp) {
		entityManager.persist(emp);
	}

	@Override
	public Employee findById(int id) {
//		Employee e = entityManager.find(Employee.class, id);
		TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee where id = :empId", Employee.class);
		typedQuery.setParameter("empId", id);
		return typedQuery.getSingleResult();
//		return entityManager.find(Employee.class, id);
	}

	@Override
	public Employee findByName(String name) {
		TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee e where e.empName = ?1", Employee.class);
		typedQuery.setParameter(1, name);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Employee> findAllRecords() {
		TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee", Employee.class);
		return typedQuery.getResultList();
	}

	@Override
	public void updateRecord(int id) {
		// find the record by id => entityManager.find()
		// update the changes in the employee object
		// entityManager.merge()
	}

	@Override
	public void deleteRecord(int id) {
		// find the record by id ==> entityManager.find()
		// delete the record using entityManager.remove(object)
		
	}

}
