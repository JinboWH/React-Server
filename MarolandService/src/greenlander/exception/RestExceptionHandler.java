package greenlander.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

public class RestExceptionHandler implements ExceptionMapper<Exception>
{
	@Override
	public Response toResponse(Exception exception)
	{
		Logger.getLogger("RestExceptionHandler").log(Level.ERROR, exception.getMessage());
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
	}
}
