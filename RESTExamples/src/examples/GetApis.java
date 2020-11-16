package examples;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/learnGET")
public class GetApis {
	
	@GET
	@Produces("application/xml")
	public String sayHelloXML() {
		String ret = "<?xml version=\"1.0\">"
			+"Hello From XML";
		return ret;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("JSON", "Hello From JSON!");
		String ret = "Greetings" + jsonObject;
		return ret;
	}
	
	
	@GET
    @Path("/get")
    public Response addUser(@HeaderParam("user-agent") String userAgent) {

        return Response.status(200)
            .entity("addUser is called, userAgent : " + userAgent)
            .build();

    }
	
	
	@GET
	@Produces("application/json")
	@PathParam("/{name}")
	public String sayHelloHuman(@PathParam("name") String name ) {
		return "Hello "+name;
	}
	
	
	// URI Pattern : “/users/2011/06/30”
	@GET
    @Path("{year}/{month}/{day}")
    public Response getUserHistory(
            @PathParam("year") int year,
            @PathParam("month") int month, 
            @PathParam("day") int day) {

       String date = year + "/" + month + "/" + day;

       return Response.status(200)
        .entity("getUserHistory is called, year/month/day : " + date)
        .build();

    }
	
	
	//URI Pattern : “users/query?from=100&to=200&orderBy=age&orderBy=name”
	@GET
	@Path("/query")
	public Response getUsers(
			@QueryParam("from") int from,
			@QueryParam("to") int to,
			@QueryParam("orderBy") List<String> orderBy) {

		return Response
				.status(200)
				.entity("getUsers is called, from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}

	@GET
	@Path("test2")
	public String testQueryParam(
			@DefaultValue("default query param value")
			@QueryParam("queryParam1") String qpString) {
		return "query param value= " + qpString;
	}	
}
