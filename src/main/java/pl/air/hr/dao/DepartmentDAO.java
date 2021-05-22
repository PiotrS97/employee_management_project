package pl.air.hr.dao;

import pl.air.hr.model.Department;

import java.time.LocalDate;
import java.util.List;

public interface DepartmentDAO {
    //CRUD -> create, read, update, delete;
    //create
    Long save(Department object);

    //read
    Department findById(Long id);
    Department findByName(String name);
    List<Department> findAll();

    //update
    void update(Department object);

    //delete
    void delete(Department object);
}
