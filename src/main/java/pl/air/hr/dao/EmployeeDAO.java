package pl.air.hr.dao;

import pl.air.hr.model.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeDAO {
    //CRUD -> create, read, update, delete;
    //create
    Long save(Employee object);

    //read
    Employee findById(Long id);
    Employee findByName(String firstName, String lastName);
    Employee findByHireDate(LocalDate hireDate);
    List<Employee> findByDepId(Long dep_id);
    List<Employee> findAll();

    //update
    void update(Employee object);

    //delete
    void delete(Employee object);
}
