package ir.ansarit.model.service;

import ir.ansarit.model.da.EmployeeDa;
import ir.ansarit.model.da.EmployeeDaImpl;
import ir.ansarit.model.entity.Employee;

import java.util.List;

public class EmployeeService {

    public Employee register(Employee employee){
        EmployeeDa employeeDa = new EmployeeDaImpl();
        employeeDa.create(employee);
        return employee;
    }

    public Employee update(Employee employee){
        EmployeeDa employeeDa = new EmployeeDaImpl();
        employeeDa.update(employee);
        return employee;
    }

    public List<Employee> findAll(){
        EmployeeDa employeeDa = new EmployeeDaImpl();
        List<Employee> employeeList = employeeDa.read();
        return employeeList;
    }

    public void remove(Employee employee){
        EmployeeDa employeeDa  = new EmployeeDaImpl();
        employeeDa.delete(employee);
    }
}
