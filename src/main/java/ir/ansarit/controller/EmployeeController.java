package ir.ansarit.controller;

import ir.ansarit.model.da.EmployeeDa;
import ir.ansarit.model.da.EmployeeDaImpl;
import ir.ansarit.model.entity.Employee;
import ir.ansarit.model.service.EmployeeService;

import javax.xml.bind.ValidationException;
import java.util.List;

public class EmployeeController {
    public Employee register(Employee employee)throws Exception{
        if (!employee.getName().equals(null) && !employee.getName().isEmpty() && !employee.getSurname().equals(null) && !employee.getSurname().isEmpty() && employee.getAge() >= 18 && employee.getAge() <= 60) {
            EmployeeService service = new EmployeeService();
            service.register(employee);
            return employee;
        }else {
            throw new ValidationException("invalid information :(");
        }
    }

    public Employee update(Employee employee) {
        EmployeeService service = new EmployeeService();
        List<Employee> employeeList = service.findAll();
        for (Employee employee1 : employeeList) {
            if (employee1.getUsername().equals(employee.getUsername()) && employee1.getPassword().equals(employee.getPassword())) {
                service.update(employee);
                return employee;

            } else {
                System.out.println("hey employee not found");
                return null;
            }

        }
        return employee;
    }

    public List<Employee> findAll(){
        EmployeeService service = new EmployeeService();
        List<Employee> employeeList = service.findAll();
        return employeeList;
    }

    public void remove(Employee employee) {
        EmployeeService service = new EmployeeService();
        List<Employee> employeeList = service.findAll();
        for (Employee employee1 : employeeList) {
            if (employee1.getPassword().equals(employee.getPassword()) && employee1.getUsername().equals(employee.getUsername())) {
                service.remove(employee);
            } else {
                System.out.println("not found or invalid");
                return;
            }
        }
    }
}
