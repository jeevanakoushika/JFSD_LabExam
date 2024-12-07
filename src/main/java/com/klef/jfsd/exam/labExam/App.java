package com.klef.jfsd.exam.labExam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {
        // Setup Hibernate session factory
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = md.getSessionFactoryBuilder().build();

        // Open a session
        Session session = sf.openSession();
        // Begin transaction
        Transaction tr = session.beginTransaction();

        try {
            // Insert Device
            Device device = new Device();
            device.setBrand("Generic Brand");
            device.setModel("Basic Model");
            device.setPrice(150.0);
            session.save(device);

            // Insert Smartphone
            Smartphone smartphone = new Smartphone();
            smartphone.setBrand("Apple");
            smartphone.setModel("iPhone 15");
            smartphone.setPrice(1200.0);
            smartphone.setOperatingSystem("iOS");
            smartphone.setCameraResolution("48 MP");
            session.save(smartphone);

            // Insert Tablet
            Tablet tablet = new Tablet();
            tablet.setBrand("Microsoft");
            tablet.setModel("Surface Pro 9");
            tablet.setPrice(1000.0);
            tablet.setScreenSize("13 inches");
            tablet.setBatteryLife(20);
            session.save(tablet);

            // Commit the transaction
            tr.commit();
            System.out.println("Records saved successfully!");
        } catch (Exception e) {
            // Rollback transaction in case of an error
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close session and factory
            session.close();
            sf.close();
        }
    }
}
