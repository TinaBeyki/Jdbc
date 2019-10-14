package ir.ansarit.view;

import ir.ansarit.controller.EmployeeController;
import ir.ansarit.model.da.EmployeeDaImpl;
import ir.ansarit.model.entity.Employee;
import ir.ansarit.model.service.EmployeeService;

import java.util.List;

public class Main {

    public static void main(String[] args)throws Exception{
        Employee employee = new Employee();
        employee.setName("Tina");
        employee.setSurname("Beyki");
        employee.setUsername("Tin");
        employee.setEmail("beyki@gmail.com");
        employee.setPassword("p");
        employee.setAge(21);
        //controller.register(employee);
         //controller.update(employee);
        //controller.remove(employee);
        EmployeeController controller = new EmployeeController();
        //EmployeeService service = new EmployeeService();
        //controller.update(employee);
        controller.remove(employee);
       /* List<Employee> employeeList = controller.findAll();
        for (Employee employee : employeeList) {
            System.out.println(employee.getSurname());
        }*/
        System.out.println("done");
    }
}
