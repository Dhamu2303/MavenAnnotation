package xyz.com.MavenAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Create Hibernate SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Create session
        Session session = sessionFactory.openSession();

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        // Retrieve the entity by ID that you want to update
        Long entityIdToUpdate = 1L; // Update with the actual ID of the entity
        ExampleEntity entityToUpdate = session.get(ExampleEntity.class, entityIdToUpdate);

        // Check if the entity exists
        if (entityToUpdate != null) {
            // Update entity
            entityToUpdate.setName("Updated Name");

            // SaveOrUpdate the entity
            session.saveOrUpdate(entityToUpdate);

            // Commit transaction
            transaction.commit();

            System.out.println("Entity updated successfully.");
        } else {
            System.out.println("Entity not found!");
        }

        // Close session and session factory
        session.close();
        sessionFactory.close();
    }
}
