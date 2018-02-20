package ManyToMany;

import OneToOne_OneToMany.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().addAnnotatedClass(Student.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetails.class)
                                                    .addAnnotatedClass(Review.class)
                                                    .configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Course course = session.get(Course.class,16);
            System.out.println(course);
            System.out.println(course.getStudents());
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }
}
