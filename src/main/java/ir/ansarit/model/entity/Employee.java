package ir.ansarit.model.entity;

import java.io.Serializable;

public class Employee implements Serializable {

    private String name;
    private String surname;
    private String username;
    private String password;
    private int age;
    private String email;

    public Employee(){

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getSurname(){
        return surname;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
