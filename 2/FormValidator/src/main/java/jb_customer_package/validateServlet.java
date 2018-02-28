package jb_customer_package;

import java.io.IOException;

import javax.persistence.Index;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        urlPatterns = "/validateServlet",
        loadOnStartup = 1,
        asyncSupported = true
)
public class validateServlet extends HttpServlet{

	/**
	 * 
	 */
	//static String error = SaveCustomer.error;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String) req.getParameter("name");
		System.out.println("Result: " + name);
		String ssn = (String) req.getParameter("ssn");
		System.out.println("Result: " + ssn);
		String zip = (String) req.getParameter("zip");
		System.out.println("Result: " + zip);
		String email = (String) req.getParameter("email");
		System.out.println("Result: " + email);
		String address = (String) req.getParameter("address");
		System.out.println("Result: " + address);
		String city = (String) req.getParameter("city");
		System.out.println("Result: " + city);
		String state = (String) req.getParameter("states");
		System.out.println("Result: " + state);
		
		String url;
		url = ("?"+"name="+name+"&ssn="+ssn+"&zip="+zip+"&email="+email+"&address="+address+"&city="+city+"&states="+state);
		//?name=jarron&ssn=333-33-3333&zip=33333-3333&email=bail@gmail.com&address=22222222222&city=chicago&states=AL
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setSsn(ssn);
		customer.setZip_code(zip);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		System.out.println("Result: " + customer);
		SaveCustomer saveCustomer = new SaveCustomer(customer);
		if (SaveCustomer.flag == true){
			System.out.println(SaveCustomer.errorValue);
			HttpSession session = req.getSession();
			session.setAttribute("error", SaveCustomer.errorValue);
			resp.sendRedirect("index.jsp");
		} else {
			resp.sendRedirect("map.jsp");
		}
		
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String) req.getAttribute("name");
		System.out.println("Result: " + name);
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
		
	}

}
