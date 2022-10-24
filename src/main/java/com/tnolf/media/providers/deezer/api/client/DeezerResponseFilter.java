package com.tnolf.media.providers.deezer.api.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tnolf.media.providers.deezer.api.model.DeezerFailure;
import lombok.extern.log4j.Log4j2;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DeezerResponseFilter implements ClientResponseFilter {
    @Override
    public void filter(ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext) throws IOException{

        InputStream entityStream = clientResponseContext.getEntityStream();

        if( entityStream == null ){
            return;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        entityStream.transferTo(baos);
        InputStream firstClone = new ByteArrayInputStream(baos.toByteArray());
        InputStream secondClone = new ByteArrayInputStream(baos.toByteArray());

        DeezerFailure response = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(firstClone, DeezerFailure.class);

        clientResponseContext.setEntityStream(secondClone);

        if( response.error != null ){
            String message = response.error.message;
            if( response.error.code == 300 ){
                throw new NotAuthorizedException(message);
            }
            throw new InternalServerErrorException(message);
        }
    }
}
