package rest;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Heater;
import domain.Home;
import domain.Person;



@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }


	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	public Home getHome() {
	    Home h = new Home(1,1);
	    
	    Heater h1 = new Heater(2000);
	    
	    Heater h2 = new Heater(3000);
	    
	    h.addChauffages(h1);
	    h.addChauffages(h2);
	    return h;
	}
	
    /*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/home")
	public Collection<Home> getHomes() {
		String query = "select h from Home as h";
		List result = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
		return result;
	}*/
	
}