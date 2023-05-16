package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;

public class JpaStarterMain {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       // Employee emp = entityManager.find(Employee.class, 7);
        Employee emp = new Employee();
        emp.setName("Suga");
        emp.setEmployeeType(EmployeeType.PART_TIME);
        System.out.println(emp);

        AccessCard accessCard1 = new AccessCard();
        accessCard1.setActive(true);
        accessCard1.setIssuedDate(new Date());
        accessCard1.setOwner(emp);
        emp.setAccessCard(accessCard1);

        PayStub payStub = new PayStub();
        payStub.setPayStubStartDate(LocalDate.now());
        payStub.setPayStubEndDate(LocalDate.now().plusDays(30));
        payStub.setSalary(5000);
        payStub.setEmployee(emp);

        PayStub payStub1 = new PayStub();
        payStub1.setPayStubStartDate(LocalDate.now());
        payStub1.setPayStubEndDate(LocalDate.now().plusDays(30));
        payStub1.setSalary(5000);
        payStub1.setEmployee(emp);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        // entityManager.remove(emp); -- for delete operation
        entityManager.persist(accessCard1);
        entityManager.persist(emp);
        entityManager.persist(payStub);
        entityManager.persist(payStub1);
        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();


//for non-existsent employee update will give NullPointerException
/*
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Foo bar");
        emp.setEmployeeType(EmployeeType.FULL_TIME);

        Employee emp1 = new Employee();
        emp1.setId(2);
        emp1.setName("Foo");
        emp1.setEmployeeType(EmployeeType.CONTRACTOR);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(emp);
        entityManager.persist(emp1);

        entityTransaction.commit();*/
    }
}
