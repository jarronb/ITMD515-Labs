package jb_customer_package;
import java.util.ArrayList;
import java.util.Set;

import javax.management.StringValueExp;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import antlr.collections.List;

public class SaveCustomer {
	
	public static ArrayList<String> errorViolation = new ArrayList();
	public static String errorValue;
	public static String erroratt;
	public static boolean flag = false;

	public SaveCustomer(Customer customerx) {
		// TODO Auto-generated constructor stub
		try {
		Customer customer = customerx;
				
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

	private static void handleConstraintViolation(ConstraintViolationException cve) {
			StringBuilder tmp = new StringBuilder();
	      Set<ConstraintViolation<?>> cvs = cve.getConstraintViolations();
				for (ConstraintViolation<?> cv : cvs) {
				System.out.println("------------------------------------------------");
				tmp.append("------------------------------------------------\n");
	          	System.out.println("Violation: " + cv.getMessage());
	          	SaveCustomer.errorViolation.add("Violation: " + cv.getMessage());
	          	System.out.println("Entity: " + cv.getRootBeanClass().getSimpleName());
	          	// The violation occurred on a leaf bean (embeddable)
	          	if (cv.getLeafBean() != null && cv.getRootBean() != cv.getLeafBean()) {
	              System.out.println("Embeddable: " + 
	cv.getLeafBean().getClass().getSimpleName());
	          }
	          System.out.println("Attribute: " + cv.getPropertyPath());
	          SaveCustomer.erroratt = ("Attribute: " + cv.getPropertyPath());
	          System.out.println("Invalid value: " + cv.getInvalidValue());
	          SaveCustomer.errorValue = ("Invalid value: " + cv.getInvalidValue());
	          SaveCustomer.flag = true;
	      }
	    }
}
	


