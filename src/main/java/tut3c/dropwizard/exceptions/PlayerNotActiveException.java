package tut3c.dropwizard.exceptions;

import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PlayerNotActiveException extends WebApplicationException {

    public PlayerNotActiveException() {
        super(Response.status(409).entity(new ErrorMessage(667, "It's not your turn, butt-face!")).type(MediaType.APPLICATION_JSON).build());
    }

}