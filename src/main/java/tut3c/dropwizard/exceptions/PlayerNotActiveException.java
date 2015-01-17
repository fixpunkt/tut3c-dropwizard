package tut3c.dropwizard.exceptions;

import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PlayerNotActiveException extends WebApplicationException {
	
	  public PlayerNotActiveException() {
			super(Response.status(409).entity(new ErrorMessage(815, "Der gewünschte Zug ist nicht erlaubt, da ein anderer Spieler aktiv ist. ")).type(MediaType.APPLICATION_JSON).build());
	  }
	  
}