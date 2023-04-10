package com.saurabh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static SessionFactory getConfiguration() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Teacher.class);
        Configuration conf1 = new Configuration().configure().addAnnotatedClass(Course.class);
        SessionFactory sf = conf.buildSessionFactory();
        return sf;
    }
    
    public static void main( String[] args )
    {
        SessionFactory sf = getConfiguration();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        
        Teacher teacher = new Teacher("Mrunali");
        Course javaCourse = new Course("Java programming");
        javaCourse.setTeacher(teacher);
        Course pythonCourse = new Course("Python programming");
        pythonCourse.setTeacher(teacher);
        Course angularCourse = new Course("Angular programming");
        angularCourse.setTeacher(teacher);
        teacher.getCourses().add(javaCourse);
        teacher.getCourses().add(pythonCourse);
        teacher.getCourses().add(angularCourse);
        
        ss.persist(teacher);
        t.commit();
        ss.close();
        sf.close();
        
        System.out.println("________________Done____________________");
    }
}
