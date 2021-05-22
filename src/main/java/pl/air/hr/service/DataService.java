package pl.air.hr.service;

import pl.air.hr.dao.DepartmentDAO;
import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.dao.ProjectDAO;
import pl.air.hr.dao.hibernate.DepartmentDAOImpl;
import pl.air.hr.dao.hibernate.EmployeeDAOImpl;
import pl.air.hr.dao.hibernate.ProjectDAOImpl;
import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DataService {
    public static void insertInitData() {
        //Utwórz działy
        Department it = createDepartment("It","Parter");
        Department hr = createDepartment("Kadry", "1. piętro");
        Department administracja = createDepartment("Administracja", "2. piętro");
        Department sprzedaz = createDepartment("Sprzedaż", "3. piętro");
        Department zarzad = createDepartment("Zarząd", "4. piętro");

        //Utwórz pracowników
        Employee kowalski = createEmployee("Adam", "Kowalski",4000,LocalDate.of(2011,05,01), hr);
        Employee nowak = createEmployee("Jan", "Nowak",4400,LocalDate.of(2001,11,14), hr);
        Employee zakrzewski = createEmployee("Arkadiusz", "Zakrzewski",5000,LocalDate.of(2017,04,26), it);
        Employee wajs = createEmployee("Karol", "Wajs",4500,LocalDate.of(2020,05,20), it);
        Employee jackowski = createEmployee("Bogdan", "Jackowski",7000,LocalDate.of(1998,9,30), it);
        Employee bogucka = createEmployee("Grażyna", "Bogucka",4000,LocalDate.of(2013,07,01), administracja);
        Employee wisniewski = createEmployee("Paweł","Wiśniewski",3600,LocalDate.of(2016,9,03), administracja);
        Employee arent = createEmployee("Tomasz", "Arent",5000,LocalDate.of(2010,12,06), sprzedaz);
        Employee tomczak = createEmployee("Adam", "Tomczak",5600,LocalDate.of(2008,10,01), sprzedaz);
        Employee szatkowski = createEmployee("Piotr", "Szatkowski",10500,LocalDate.of(1997,05,04), zarzad);

        //utwórz projekty
        Project projekt1 = createProject("Współpraca z firmą X",LocalDate.of(2017,10,04),LocalDate.of(2020,9,18),kowalski,zakrzewski,jackowski,szatkowski);
        Project projekt2 = createProject("Tworzenie aplikacji Y",LocalDate.of(2014,04,01),LocalDate.of(2015,10,10),jackowski,arent,nowak);

        // zapisz dane w bazie danych
        HibernateService.beginTransaction();
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        departmentDAO.save(it);
        departmentDAO.save(hr);
        departmentDAO.save(administracja);
        departmentDAO.save(sprzedaz);
        departmentDAO.save(zarzad);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.save(kowalski);
        employeeDAO.save(nowak);
        employeeDAO.save(zakrzewski);
        employeeDAO.save(wajs);
        employeeDAO.save(jackowski);
        employeeDAO.save(bogucka);
        employeeDAO.save(wisniewski);
        employeeDAO.save(arent);
        employeeDAO.save(tomczak);
        employeeDAO.save(szatkowski);

        ProjectDAO projectDAO = new ProjectDAOImpl();
        projectDAO.save(projekt1);
        projectDAO.save(projekt2);

        HibernateService.commitTransaction();
    }
    private static Department createDepartment(String name, String location) {
        Department one = new Department();
        one.setName(name);
        one.setLocation(location);
        return one;
    }

    private static Project createProject(String name, LocalDate startDate, LocalDate endDate, Employee... employees) {
        Project one = new Project();
        one.setName(name);
        one.setStartDate(startDate);
        one.setEndDate(endDate);
        one.setEmployees(List.of(employees));
        return one;
    }

    private static Employee createEmployee(String firstName, String lastName, double salary, LocalDate hireDate, Department department) {
        Employee one = new Employee();
        one.setFirstName(firstName);
        one.setLastName(lastName);
        one.setSalary(new BigDecimal(salary));
        one.setDepartment(department);
        return one;
    }
}
