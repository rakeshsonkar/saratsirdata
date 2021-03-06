/**
 * 
 */
package in.ifms.employee.repository.impl;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;
import javax.transaction.Transactional;

import in.ifms.employee.entity.Employee;
import in.ifms.employee.repository.EmployeeRepository;

/**
 * @author hp
 *
 */
@Dependent
public class EmployeeRepositoryImpl implements EmployeeRepository {

	/**
	 * 
	 */
	/* PersistenceContext marks that the EntityManager is container managed */
	@PersistenceContext(unitName = "employeePersistenceUnit")
	EntityManager entityManager;

	/**
	 * 
	 */
	public EmployeeRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Inject public EmployeeRepositoryImpl(EntityManager entityManager) {
	 * this.entityManager = entityManager; }
	 */

	@Override
	public Employee getEmployeeById(Integer type) throws IllegalArgumentException, EntityNotFoundException {
		//clearing the cache of stale data
		//entityManager.clear();
		Employee employee = entityManager.find(Employee.class, type);
		return employee;
	}

	// @Transactional(value = TxType.REQUIRED, rollbackOn = {
	// EntityNotFoundException.class, RuntimeException.class })
	@Transactional
	@Override
	public Employee createOrUpdate(Employee employee) throws IllegalArgumentException, EntityNotFoundException, TransactionRequiredException{
		entityManager.persist(employee);
		entityManager.flush();
		//entityManager.getTransaction().commit();
		return employee;
	}

	/**
	 * This will get Employee from the database, when employeeId is passed within a
	 * JPQL query string
	 * 
	 * @param queryStr query as String type
	 * @return Employee instance with the given employee_id
	 * @throws @{@link IllegalArgumentException}
	 */
	@Override
	public Employee getByEmployeeIdJpql(String queryStr) {
		Query query = entityManager.createQuery(queryStr);
		Employee employee = (Employee) query.setParameter("employeeId", queryStr).getSingleResult();
		return employee;
	}

	/**
	 * This will get Employee from the database, when employeeId is passed within a
	 * SQL query string
	 * 
	 * @param queryStr SQL query as String type
	 * @return Employee instance with the given employeeId
	 * @throws @{@link IllegalArgumentException}
	 */
	@Override
	public Employee getByEmployeeIdSql(String queryStr) {
		Query query = entityManager.createQuery(queryStr);
		Employee employee = (Employee) query.setParameter("employeeId", queryStr).getSingleResult();
		return employee;
	}

	/**
	 * This will create a new Employee in the corresponding table in the database
	 * 
	 * @param employee Employee entity instance with all valid columns
	 * @throws @{@link EntityExistsException}
	 */
	@Override
	@Transactional
	public void create(Employee employee) {
		entityManager.persist(employee);
	}

	/**
	 * This will upate name and email of an Employee in the corresponding table in the database
	 * 
	 * @param employee Employee entity instance with all valid columns
	 * @param queryStr native SQL query as String
	 * @throws @{@link EntityExistsException}
	 */
	@Override
	@Transactional
	public int update(Employee employee, String queryStr) throws IllegalStateException, TransactionRequiredException, QueryTimeoutException, PersistenceException{
		Query query = entityManager.createQuery(queryStr);
		int rows = 0;
		query.setParameter("employeeName", employee.getEmployeeName());
		query.setParameter("email", employee.getEmail());
		query.setParameter("employeeId", employee.getEmployeeId());
		rows = query.executeUpdate();
		return rows;
		
	}

}
