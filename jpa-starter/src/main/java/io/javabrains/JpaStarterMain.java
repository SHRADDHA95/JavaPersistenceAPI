package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee emp = entityManager.find(Employee.class , 1);
        emp.setEmployeeType(EmployeeType.PART_TIME);
        System.out.println(emp);
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(emp);
        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();



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
