package tut3c.dropwizard.exceptions;

import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class FieldAlreadySetException extends WebApplicationException {

    public FieldAlreadySetException() {
        super(Response.status(409).entity(new ErrorMessage(666, "Field is already occupied.")).type(MediaType.APPLICATION_JSON).build());
    }
}