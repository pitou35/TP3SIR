package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevices;
import domain.Heater;
import domain.Home;
import domain.Person;

public class JpaTest {
	
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			Person p1 = new Person("pitou", "toutou", "@france.fr");
			Person p2 = new Person("marco", "polo", "@italy.it");
			Home h1=new Home(20,20);
			h1.setOwner(p1);
			ElectronicDevices e1=new ElectronicDevices(20);
			ElectronicDevices e2=new ElectronicDevices(20);
			ElectronicDevices e3=new ElectronicDevices(20);
			ElectronicDevices e4=new ElectronicDevices(20);
			e1.setOwner(p1);
			e2.setOwner(p1);
			e3.setOwner(p1);
			e4.setOwner(p1);
			Heater he1=new Heater(1800);
			Heater he2=new Heater(1800);
			Heater he3=new Heater(1800);
			Heater he4=new Heater(1800);
			he1.setOwner(h1);
			he2.setOwner(h1);
			he3.setOwner(h1);
			he4.setOwner(h1);
			
			manager.persist(p1);
			manager.persist(p2);
			manager.persist(h1);
			manager.persist(he1);
			manager.persist(he2);
			manager.persist(he3);
			manager.persist(he4);
			manager.persist(e1);
			manager.persist(e2);
			manager.persist(e3);
			manager.persist(e4);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		/*String s = "SELECT e FROM Person as e where e.nom=:name";
			
		Query q = manager.createQuery(s,Person.class);
		q.setParameter("name", "totaro"); 
		List<Person> res = q.getResultList();
		
		System.err.println(res.size());
		System.err.println(res.get(0).getNom());
		*/
		
		
		manager.close();
		factory.close();
	}
	
	


	

}
