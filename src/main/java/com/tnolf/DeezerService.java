package com.tnolf;

import com.tnolf.deezer.DeezerFilter;
import com.tnolf.deezer.model.DeezerResponse;
import com.tnolf.deezer.model.Playlist;
import com.tnolf.deezer.model.Track;
import com.tnolf.deezer.model.User;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@RegisterRestClient(baseUri = "https://api.deezer.com")
@RegisterProvider(DeezerFilter.class)
public interface DeezerService {

    @GET
    @Path("user/me")
    Uni<User> getUserInfo(@QueryParam("access_token") String token);

    @GET
    @Path("user/me/playlists")
    Uni<DeezerResponse<Playlist>> getUserPlaylists(@QueryParam("access_token") String token);

    @GET
    @Path("playlist/{id}/tracks")
    Uni<DeezerResponse<Track>> getPlaylistTracks(@QueryParam("access_token") String token, @PathParam("id") long id);
}
