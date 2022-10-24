package com.tnolf.media.providers.deezer.api.client;

import lombok.extern.log4j.Log4j2;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

@Log4j2
public class DeezerRequestFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException{
        String authorization = clientRequestContext.getHeaderString("Authorization");
        URI uri = UriBuilder.fromUri(clientRequestContext.getUri())
                .queryParam("access_token", authorization.replace("Bearer ", ""))
                .build();
        clientRequestContext.setUri(uri);
    }
}
