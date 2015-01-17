package com.example.helloworld;

import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class FieldAlreadySetException extends WebApplicationException {

	public FieldAlreadySetException() {
		super(Response.status(409).entity(new ErrorMessage(815, "Feld wurde bereits gesetzt. ")).type(MediaType.APPLICATION_JSON).build());
	}
}