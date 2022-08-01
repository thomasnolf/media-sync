package com.tnolf;

import com.tnolf.deezer.model.DeezerResponse;
import com.tnolf.deezer.model.Playlist;
import com.tnolf.deezer.model.Track;
import com.tnolf.deezer.model.User;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestHeader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/deezer")
public class DeezerResource {

    @RestClient
    DeezerService deezerService;

    @GET
    @Path("me")
    public Uni<User> getUserInfo(@RestHeader("dz-token") String token){

        return deezerService.getUserInfo(token);
    }

    @GET
    @Path("me/playlists")
    public Uni<DeezerResponse<Playlist>> getUserPlaylists(@RestHeader("dz-token") String token){

        return deezerService.getUserPlaylists(token);
    }

    @GET
    @Path("playlist/{id}/tracks")
    public Uni<DeezerResponse<Track>> getPlaylistTracks(@RestHeader("dz-token") String token, @PathParam("id") long id){

        return deezerService.getPlaylistTracks(token, id);
    }

}
