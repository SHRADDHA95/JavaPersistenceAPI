package io.javabrains;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PayStub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate payStubStartDate;
    private LocalDate payStubEndDate;
    private float salary;

    @ManyToOne
    private  Employee employee;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPayStubStartDate() {
        return payStubStartDate;
    }

    public void setPayStubStartDate(LocalDate payStubStartDate) {
        this.payStubStartDate = payStubStartDate;
    }

    public LocalDate getPayStubEndDate() {
        return payStubEndDate;
    }

    public void setPayStubEndDate(LocalDate payStubEndDate) {
        this.payStubEndDate = payStubEndDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
