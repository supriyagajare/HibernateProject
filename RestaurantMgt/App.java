package HibernateProj.RestaurantMgt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	
    	System.out.println("Hello");
		Configuration config=new Configuration().configure().addAnnotatedClass(RestaurantsMgt.class);
		SessionFactory sessionFact = config.buildSessionFactory();
		Session session = sessionFact.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
    	
	}
}
