package pl.air.hr.service;

import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PrintService {
    //employee
    private static String getEmployee(Employee one) {
        Long id = one.getId();
        String firstName = one.getFirstName();
        String lastName = one.getLastName();
        BigDecimal salary = one.getSalary();

        return String.format("%s %s (id = %d) Pensja: %s" , firstName, lastName, id, salary);
    }

    public static void printEmployee(Employee one) {
        String printout = getEmployee(one);
        System.out.print(printout);
        System.out.print(" Dział: ");
        printDepartment(one.getDepartment());
    }

    public static void printEmployeeList(List<Employee> list) {
        String printout = "";
        for (Employee one : list) {
            printout += getEmployee(one) + ", ";
        }
        printout = printout.substring(0, printout.lastIndexOf(","));
        System.out.println(printout);
    }

    //department
    private static String getDepartment(Department one) {
        Long id = one.getId();
        String name = one.getName();

        return String.format("%s (id = %d)", name, id);
    }

    public static void printDepartment(Department one) {
        String printout = getDepartment(one);
        System.out.println(printout);
    }
    public static void printDepartmentList(List<Department> list) {
        String printout = "";
        for (Department one : list) {
            printout += getDepartment(one) + ", ";
        }
        printout = printout.substring(0, printout.lastIndexOf(","));
        System.out.println(printout);
    }

    //project
    private static String getProject(Project one){
        Long id = one.getId();
        String name = one.getName();
        LocalDate startDate = one.getStartDate();
        LocalDate endDate = one.getEndDate();

        return String.format("%s (id = %d) Start date: %s, End date: %s",name, id, startDate,endDate );
    }
    private static void printProject(Project one){
        String printout = getProject(one);
        System.out.print(printout);
        System.out.print(" Uczestnicy projektu: ");
        List<Employee> employees = one.getEmployees();
        printEmployeeList(employees);
    }
    public static void printProjectList(List<Project> list) {
        String printout = "";
        for (Project one : list) {
            printout += getProject(one) + ", ";
        }
        printout = printout.substring(0, printout.lastIndexOf(","));
        System.out.println(printout);
    }
}
