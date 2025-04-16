package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hib.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration cfg=new Configuration();
        cfg.configure();
        
        
        SessionFactory sf= cfg.buildSessionFactory();
        
//        Session session= new Configuration().configure().buildSessionFactory().openSession();
          Session session=sf.openSession();
        
//        Transaction tx= session.beginTransaction();
        
        
        Student s1=new Student(101,"Ram");
//        session.save(s1);
        
        Student s= session.get(Student.class, 101);
        System.out.println(s);
        
        session.close();
        Session session2=sf.openSession();
        
        Student s2=session2.get(Student.class, 101);
        System.out.println(s2);
        
        
        
//        tx.commit();
        session2.close();
        sf.close();
        System.out.println("----------------END----------------");
        
    }
}
