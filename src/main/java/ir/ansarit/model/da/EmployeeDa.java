package ir.ansarit.model.da;

import ir.ansarit.model.entity.Employee;

import java.util.List;

public interface EmployeeDa {

    Employee create(Employee employee);
    Employee update(Employee employee);
    List<Employee> read();
    void delete(Employee employee);

}
