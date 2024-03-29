package pl.air.hr.dao.hibernate;

import pl.air.hr.dao.DepartmentDAO;
import pl.air.hr.model.Department;
import pl.air.hr.service.HibernateService;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    private Session getSession() {return HibernateService.getSession();}

    @Override
    public Long save(Department object) {
        Serializable id = getSession().save(object);
        return(Long) id;
    }

    @Override
    public Department findById(Long id) {

        Department one = getSession().get(Department.class, id);
        return one;
    }

    @Override
    public Department findByName(String name) {
        Query<Department> query = getSession().createQuery("from Department where name = :name", Department.class);
        query.setParameter("name", name);
        Department one = query.getSingleResult();
        return one;
    }

    @Override
    public List<Department> findAll() {
        Query<Department> query = getSession().createQuery("from Department ", Department.class);
        List<Department> all = query.getResultList();
        return all;
    }

    @Override
    public void update(Department object) {
        getSession().update(object);
    }

    @Override
    public void delete(Department object) {
        getSession().delete(object);
    }
}
