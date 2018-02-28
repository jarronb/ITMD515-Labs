package jb_customer_package;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Customer customer1 = new Customer();
		
	
		customer1.setId(1);
		customer1.setName("Jay Bay");
		customer1.setSsn("333-33-3333");
		customer1.setZip_code("6043-4323");
		customer1.setEmail("baileyjarron@gmail.com");
		customer1.setAddress("22222 S Matthew");
		customer1.setCity("Chicago");
		customer1.setState("IL");
		
	
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		session.save(customer1);
		
	
		transaction.commit();
		}catch (ConstraintViolationException e) {
			// TODO: handle exception
			handleConstraintViolation(e);
		}
	
	}
	
	private static void handleConstraintViolation(ConstraintViolationException cve) {
	      Set<ConstraintViolation<?>> cvs = cve.getConstraintViolations();
				for (ConstraintViolation<?> cv : cvs) {
						System.out.println("------------------------------------------------");
	          	System.out.println("Violation: " + cv.getMessage());
	          	System.out.println("Entity: " + cv.getRootBeanClass().getSimpleName());
	          	// The violation occurred on a leaf bean (embeddable)
	          	if (cv.getLeafBean() != null && cv.getRootBean() != cv.getLeafBean()) {
	              System.out.println("Embeddable: " + 
	cv.getLeafBean().getClass().getSimpleName());
	          }
	          System.out.println("Attribute: " + cv.getPropertyPath());
	          System.out.println("Invalid value: " + cv.getInvalidValue());
	      }
	    }
	
	public void beginApp(Customer customer) {
		try {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		
		session.save(customer);
		
	
		transaction.commit();
		}catch (ConstraintViolationException e) {
			// TODO: handle exception
			handleConstraintViolation(e);
		}
		
	}
}
