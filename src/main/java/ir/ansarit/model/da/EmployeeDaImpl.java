package ir.ansarit.model.da;

import ir.ansarit.model.entity.Employee;

import javax.xml.bind.ValidationException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaImpl implements EmployeeDa {

    private Connection connection;
    private PreparedStatement preparedStatement;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public EmployeeDaImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "bebsoft");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee create(Employee employee) {
        try {
                preparedStatement = connection.prepareStatement("insert into employee(name, surname,username,password, age, email)values(?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getSurname());
                preparedStatement.setString(3, employee.getUsername());
                preparedStatement.setString(4, employee.getPassword());
                preparedStatement.setInt(5, employee.getAge());
                preparedStatement.setString(6, employee.getEmail());
                preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }

    public Employee update(Employee employee) {
        try {
             preparedStatement = connection.prepareStatement("update employee set name = ?, surname = ?, age = ?, email =? where username = ? and password = ?");
             preparedStatement.setString(1, employee.getName());
             preparedStatement.setString(2, employee.getSurname());
             preparedStatement.setInt(3, employee.getAge());
             preparedStatement.setString(4, employee.getEmail());
             preparedStatement.setString(5, employee.getUsername());
             preparedStatement.setString(6, employee.getPassword());
             preparedStatement.executeUpdate();
             return employee;
        } catch (Exception e) {
            System.out.println("Exception :(");
            return null;
        }
    }

    public List<Employee> read() {
        try {
            preparedStatement = connection.prepareStatement("select * from employee");
            List<Employee> employeeList = new ArrayList<Employee>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setPassword(resultSet.getString("password"));
                employee.setUsername(resultSet.getString("username"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAge(resultSet.getInt("age"));
                employeeList.add(employee);
            }
            return employeeList;
        } catch (Exception e) {
            System.out.println("Exception :(");
            return null;
        }
    }

    public void delete(Employee employee) {
        try {
                    preparedStatement = connection.prepareStatement("delete from employee where username = ? and password = ?");
                    preparedStatement.setString(1, employee.getUsername());
                    preparedStatement.setString(2, employee.getPassword());
                    preparedStatement.executeUpdate();
                    System.out.println("removed successfully");
        } catch (Exception e) {
            System.out.println("Exception :(");
        }
    }
}
