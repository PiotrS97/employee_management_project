package pl.air.hr.dao;

import pl.air.hr.model.Project;

import java.time.LocalDate;
import java.util.List;

public interface ProjectDAO {
    //CRUD -> create, read, update, delete;
    //create
    Long save(Project object);

    //read
    Project findById(Long id);
    Project findByName(String name);
    Project findByStartDate(LocalDate startDate);
    List<Project> findByEmployeeId(Long employee_id);
    List<Project> findAll();

    //update
    void update(Project object);

    //delete
    void delete(Project object);
}
