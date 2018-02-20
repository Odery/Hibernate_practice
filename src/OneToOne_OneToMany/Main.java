package OneToOne_OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(InstructorDetails.class)
                                                    .addAnnotatedClass(Review.class)
                                                    .configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            ///Retrieving Instructor Entity using session
            Instructor instructor1 = session.get(Instructor.class,1);
            System.out.println(instructor1.getCourses());
            System.out.println(instructor1.getDetails());

            //Retrieving Instructor Entity using HQL
            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i "
                                                            +"JOIN FETCH i.courses WHERE i.id =:id",
                                                            Instructor.class);
            query.setParameter("id",2);

            Instructor instructor2 = query.getSingleResult();
            System.out.println(instructor2.getCourses());
            System.out.println(instructor2.getDetails());

            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }
}
