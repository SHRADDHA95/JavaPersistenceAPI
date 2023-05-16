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

    @OneToOne(cascade = CascadeType.PERSIST)
    //-This will allow Hibernate to save the AccessCard instance when the Employee instance is saved,
    // avoiding the TransientPropertyValueException.
    // FetchType.LAZY will only fetch the data when access card's getter is called from employee instance
    private AccessCard accessCard;

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

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
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
