package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Heater;
import domain.Home;

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
	    //h.setName("toto");
	    Heater h1 = new Heater(2000);
	    //h1.setPower("500w");
	    Heater h2 = new Heater(3000);
	    //h2.setPower("600w");
	    h.addChauffages(h1);
	    h.addChauffages(h2);
	    return h;
	}
}