package greenlander.exception;

import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.spi.DefaultOptionsMethodException;

@Provider
public class OptionsHander implements ExceptionMapper<DefaultOptionsMethodException>
{
	private static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
	private static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";

	private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
	private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";

	@Context HttpHeaders httpHeaders;
	
	@Override
	public Response toResponse(DefaultOptionsMethodException exception) {

	    final ResponseBuilder response = Response.ok();

	    String requestHeaders = httpHeaders.getHeaderString(ACCESS_CONTROL_REQUEST_HEADERS);
	    String requestMethods = httpHeaders.getHeaderString(ACCESS_CONTROL_REQUEST_METHOD);

	    if (requestHeaders != null)
	        response.header(ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders);

	    if (requestMethods != null)
	        response.header(ACCESS_CONTROL_ALLOW_METHODS, requestMethods);

	    // TODO: development only, too permissive

	    return response.build();
	}
}
