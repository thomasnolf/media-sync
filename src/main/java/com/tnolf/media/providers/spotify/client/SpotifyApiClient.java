package com.tnolf.media.providers.spotify.client;

import com.tnolf.media.providers.spotify.model.SpotifyPlaylist;
import com.tnolf.media.providers.spotify.model.SpotifyResponse;
import com.tnolf.media.providers.spotify.model.SpotifyTrack;
import com.tnolf.media.providers.spotify.model.SpotifyUser;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@RegisterRestClient(baseUri = "https://api.spotify.com/v1/")
@RegisterClientHeaders
public interface SpotifyApiClient {

    @GET
    @Path("/me")
    Uni<SpotifyUser> getUserInfo();

    @GET
    @Path("/me/playlists")
    Uni<SpotifyResponse<SpotifyPlaylist>> getUserPlaylists(@QueryParam("offset") int offset, @QueryParam("limit") int limit);

    @GET
    @Path("playlist/{id}/tracks")
    Uni<SpotifyResponse<SpotifyTrack>> getPlaylistTracks(@PathParam("id") long id);
}
