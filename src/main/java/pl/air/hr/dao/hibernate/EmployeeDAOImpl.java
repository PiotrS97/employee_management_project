package pl.air.hr.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.model.Employee;
import pl.air.hr.service.HibernateService;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private Session getSession(){return HibernateService.getSession();}

    @Override
    public Long save(Employee object) {
        Serializable id = getSession().save(object);
        return (Long) id;
    }

    @Override
    public Employee findById(Long id) {
        Employee one = getSession().get(Employee.class, id);
        return one;
    }

    @Override
    public Employee findByName(String firstName, String lastName) {
        Query<Employee> query = getSession().createQuery("from Employee where firstName = :firstName and lastName = :lastName", Employee.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        Employee one = query.getSingleResult();
        return one;
    }

    @Override
    public Employee findByHireDate(LocalDate hireDate) {
        return null;
    }

    @Override
    public List<Employee> findByDepId(Long dep_id) {
        Query<Employee> query = getSession().createQuery("from Employee where department = :department", Employee.class);
        query.setParameter("department", dep_id);
        List<Employee> list = query.getResultList();
        return list;
    }

    @Override
    public List<Employee> findAll() {
        Query<Employee> query = getSession().createQuery("from Employee ", Employee.class);
        List<Employee> all = query.getResultList();
        return all;
    }

    @Override
    public void update(Employee object) {
        getSession().update(object);
    }

    @Override
    public void delete(Employee object) {
        getSession().delete(object);
    }
}
