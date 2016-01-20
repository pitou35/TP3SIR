package jpa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Person;

@WebServlet(name="addHouse",urlPatterns={"/addHouse"})
public class TP3Question5 extends HttpServlet{

	public static void main(String[] args) {
		
		
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("mysql");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			
			try {
				Person p1=new Person(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("mail"));
				manager.persist(p1);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			manager.close();
			factory.close();
			
			
			
			out.println("<HTML>\n<BODY>\n" +
					"<H1>Recapitulatif des informations</H1>\n" +
					"<UL>\n" +			
			" <LI>Nom: "
					+ request.getParameter("email") + "\n" +
					" <LI>Prenom: "
					+ request.getParameter("nom") + "\n" +
					" <LI>Age: "
					+ request.getParameter("prenom") + "\n" +
					"</UL>\n" +				
			"</BODY></HTML>");
	}
}