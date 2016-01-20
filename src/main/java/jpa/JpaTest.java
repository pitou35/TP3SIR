package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevices;
import domain.Heater;
import domain.Home;
import domain.Person;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			
			
			Person p1 = new Person("pitou", "toutou", "@");
			Home h1=new Home(20,20);
			h1.setOwner(p1);
			ElectronicDevices e1=new ElectronicDevices(2000);
			e1.setOwner(p1);
			Heater he1=new Heater(2000);
			he1.setOwner(h1);
			
			
			manager.persist(p1);
			manager.persist(h1);
			manager.persist(he1);
			manager.persist(e1);
			
			
			
			
			
		
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

	private static void old(EntityManager manager) {
		Heater h=new Heater(1800);
		Heater h2=new Heater(1800);
		Heater h3=new Heater(1800);
		Heater h4=new Heater(1800);
		
		/*ElectronicDevices e1=new ElectronicDevices(20);
		ElectronicDevices e2=new ElectronicDevices(20);
		ElectronicDevices e3=new ElectronicDevices(20);
		ElectronicDevices e4=new ElectronicDevices(20);
		*/
		manager.persist(h);
		manager.persist(h2);
		manager.persist(h3);
		manager.persist(h4);
		
		/*manager.persist(e1);
		manager.persist(e2);
		manager.persist(e3);
		manager.persist(e4);*/
		
		
		Home m=new Home(200, 9);
		m.addChauffages(h);
		m.addChauffages(h2);
		m.addChauffages(h3);
		m.addChauffages(h4);
		manager.persist(m);
		
		ElectronicDevices Elect = new ElectronicDevices(2000);
		manager.persist(Elect);
		

		Person p = new Person("tutu", "pitou", "pitou@toto.fr");
		p.setNom("totaro");
		p.addMaisons(m);
		/*p.addElec(Elect);
		p.addElec(e1);
		p.addElec(e2);
		p.addElec(e3);
		p.addElec(e4);*/
		manager.persist(p);
	}

}
