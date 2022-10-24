package com.tnolf.media.providers.deezer.api.client;

import com.tnolf.media.providers.deezer.api.model.DeezerResponse;
import com.tnolf.media.providers.deezer.api.model.DeezerPlaylist;
import com.tnolf.media.providers.deezer.api.model.DeezerTrack;
import com.tnolf.media.providers.deezer.api.model.DeezerUser;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RegisterRestClient(baseUri = "https://api.deezer.com")
@RegisterProvider( DeezerRequestFilter.class)
@RegisterProvider( DeezerResponseFilter.class)
@RegisterClientHeaders
public interface DeezerApiClient {

    @GET
    @Path("user/me")
    Uni<DeezerUser> getUserInfo();

    @GET
    @Path("user/me/playlists")
    Uni<DeezerResponse<DeezerPlaylist>> getUserPlaylists();

    @GET
    @Path("playlist/{id}/tracks")
    Uni<DeezerResponse<DeezerTrack>> getPlaylistTracks(@PathParam("id") long id);
}
