package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAStarterFetch {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee emp = entityManager.find(Employee.class, 0);

        System.out.println("********************* Employee instance");
        System.out.println(emp);

        System.out.println("************Access Card details");
        System.out.println(emp.getAccessCard());

        entityManager.close();
        entityManagerFactory.close();
    }
}
