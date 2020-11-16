package examples;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionMapper extends Exception implements ExceptionMapper<RuntimeException>
{
    @Override
    public Response toResponse(RuntimeException ex)
    {
        // In this example, we just return the .toString() of the exception. 
        // You might want to wrap this in a JSON structure if this is a JSON API, for example.
        return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(ex.toString())
            .build();
    }
}
