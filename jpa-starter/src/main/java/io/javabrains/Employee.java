package io.javabrains;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    @Id
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeType=" + employeeType +
                '}';
    }
}
