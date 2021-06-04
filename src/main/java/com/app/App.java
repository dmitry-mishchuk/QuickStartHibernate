package com.app;

import com.app.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Student Bob = new Student();

        //Bob.setId(101);
        Bob.setName("Bob");
        Bob.setAge(20);

        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(Student.class);

        StandardServiceRegistryBuilder bidder1 = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());

        SessionFactory sf = con.buildSessionFactory(bidder1.build());

        //Create
        /*Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(Bob);
        tx.commit();
        session.close();*/

        //Read
        Session sessionRead = sf.openSession();
        Transaction txRead = sessionRead.beginTransaction();
        Student student1 = sessionRead.find(Student.class, 1);
        System.out.println(student1.toString());
        txRead.commit();
        sessionRead.close();
    }
}
