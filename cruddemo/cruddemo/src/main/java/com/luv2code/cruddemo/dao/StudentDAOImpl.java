package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

	//define field for entity manager
	
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	//implement save method

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	// implement findById method
	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	// find all implementation
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
//		Create query
		 TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
		 
		
//		return query results
		return theQuery.getResultList();
	}


	@Override
	public List<Student> findByLastName(String lastName) {
		// Create query
		TypedQuery<Student> theQuery = entityManager.createQuery(
				"FROM Student WHERE lastName = :theData", Student.class);
		
		//set query parameters
		theQuery.setParameter("theData", lastName);
		
		//return query results
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public void update(Student student) {
		// TODO Auto-generated method 

		entityManager.merge(student);
		
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Student theStudent = entityManager.find(Student.class,id);
		
		entityManager.remove(theStudent);
		
	}


	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}

	

}
