package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().addAnnotatedClass(Student.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetails.class)
                                                    .configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }
}
