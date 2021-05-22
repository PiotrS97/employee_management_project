package pl.air.hr.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.air.hr.dao.ProjectDAO;
import pl.air.hr.model.Project;
import pl.air.hr.service.HibernateService;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    private Session getSession(){
        return HibernateService.getSession();
    }

    @Override
    public Long save(Project object) {
        Serializable id = getSession().save(object);
        return (Long) id;
    }

    @Override
    public Project findById(Long id) {
        Project one = getSession().get(Project.class, id);
        return one;
    }

    @Override
    public Project findByName(String name) {
        Query<Project> query = getSession().createQuery("from Project where name = :name", Project.class);
        query.setParameter("name", name);
        Project one = query.getSingleResult();
        return one;
    }

    @Override
    public Project findByStartDate(LocalDate startDate) {
        return null;
    }

    @Override
    public List<Project> findByEmployeeId(Long employee_id) {
        return null;
    }

    @Override
    public List<Project> findAll() {
        Query<Project> query = getSession().createQuery("from Project", Project.class);
        List<Project> all = query.getResultList();
        return all;
    }

    @Override
    public void update(Project object) {
getSession().update(object);
    }

    @Override
    public void delete(Project object) {
getSession().delete(object);
    }
}
