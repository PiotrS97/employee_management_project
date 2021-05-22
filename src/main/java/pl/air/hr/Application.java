package pl.air.hr;

import pl.air.hr.dao.DepartmentDAO;
import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.dao.ProjectDAO;
import pl.air.hr.dao.hibernate.DepartmentDAOImpl;
import pl.air.hr.dao.hibernate.EmployeeDAOImpl;
import pl.air.hr.dao.hibernate.ProjectDAOImpl;
import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;
import pl.air.hr.service.DataService;
import pl.air.hr.service.HibernateService;
import pl.air.hr.service.PrintService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("Start");
        // uruchom Hibernate
        HibernateService.startup();

        // wstaw dane do tabel w bazie danych
        DataService.insertInitData();

        //dao
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        ProjectDAO projectDAO = new ProjectDAOImpl();

        //początek transakcji
        HibernateService.beginTransaction();

        Employee kow = employeeDAO.findByName("Adam", "Kowalski");
        PrintService.printEmployee(kow);
        Department it = departmentDAO.findByName("It");
        PrintService.printDepartment(it);
        List<Project> proj = projectDAO.findAll();
        PrintService.printProjectList(proj);
        List<Department> deps = departmentDAO.findAll();
        PrintService.printDepartmentList(deps);
        List<Employee> emp = employeeDAO.findAll();
        PrintService.printEmployeeList(emp);


        //Koniec transakcji
        HibernateService.commitTransaction();
        //zakończ hibernate
        HibernateService.shutdown();
        System.out.println("Koniec");

    }
}
