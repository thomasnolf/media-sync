package com.tnolf.rest;

import org.jboss.resteasy.reactive.ClientWebApplicationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ClientWebApplicationExceptionMapper implements ExceptionMapper<ClientWebApplicationException> {
    @Override
    public Response toResponse(ClientWebApplicationException t) {
        return Response.status(t.getResponse().getStatus()).build();
    }
}
