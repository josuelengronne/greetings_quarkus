package resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import java.util.List;

import model.Greeting;
import services.GreetingService;

@Path("/greetings")
public class GreetingResource {

    @Inject
    private GreetingService greetingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Greeting> get(
        @DefaultValue("5")
        @QueryParam("limit") int limit
    ) {
        return greetingService.getLatest(limit);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(
        Greeting greeting
    ) {
        greetingService.addGreeting(greeting);
        return Response.ok().build();
    }
}