package examples;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/post")
public class PostApis {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response simplePost(String input) {
		return Response.status(200).entity("Recieved "+input).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response simplePost2(@QueryParam("input") String input) throws MyExceptionMapper {
		if(input == null)
			throw new MyExceptionMapper();
		return Response.status(200).entity("Recieved "+input).build();
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/met3/{input}")
	public Response simplePost3(@PathParam("input") String input) throws MyExceptionMapper {
		if(input == null)
			throw new MyExceptionMapper();
		return Response.status(200).entity("Recieved "+input).build();
	}
}
