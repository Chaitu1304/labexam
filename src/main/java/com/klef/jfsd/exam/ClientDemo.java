package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        // Load configuration
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Insert records (Persistent Object)
        Transaction transaction = session.beginTransaction();
        Client client1 = new Client();
        client1.setName("Krishna");
        client1.setGender("Male");
        client1.setAge(20);
        client1.setLocation("Bhimavaram");
        client1.setEmail("k@gmail.com");
        client1.setMobileNumber("1234567890");

        Client client2 = new Client();
        client2.setName("Chaitanya");
        client2.setGender("Male");
        client2.setAge(15);
        client2.setLocation("Chinnamaram");
        client2.setEmail("c@gmail.com");
        client2.setMobileNumber("0987654321");

        session.save(client1);
        session.save(client2);
        transaction.commit();

        // Print all records using HQL
        List<Client> clients = session.createQuery("FROM Client", Client.class).list();
        for (Client client : clients) {
            System.out.println(client);
        }

        // Close the session
        session.close();
        sessionFactory.close();
    }
}
