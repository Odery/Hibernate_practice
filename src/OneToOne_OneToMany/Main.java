package OneToOne_OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(InstructorDetails.class)
                                                    .configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            //CRUD commands here

            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }
}
