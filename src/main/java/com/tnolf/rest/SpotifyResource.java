package com.tnolf.rest;

import com.tnolf.media.providers.spotify.client.SpotifyApiClient;
import com.tnolf.rest.model.Playlist;
import com.tnolf.rest.model.Response;
import com.tnolf.rest.model.Track;
import com.tnolf.rest.model.User;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/spotify" )
@Produces( MediaType.APPLICATION_JSON )
@RequiredArgsConstructor
public class SpotifyResource {

    @RestClient
    SpotifyApiClient api;

    private final MyMapper mapper;

    @GET
    @Path( "me" )
    public Uni<User> getUserInfo(){
        return api.getUserInfo()
                .map(mapper::spotifyUserToUser);
    }

    @GET
    @Path( "playlists" )
    public Uni<Response<Playlist>> getUserPlaylists(@QueryParam("offset") int offset, @QueryParam("limit") int limit){
        return api.getUserPlaylists(offset, limit)
                .map(mapper::spotifyPlayListResponseToResponse);
    }

    @GET
    @Path( "playlist/{id}/tracks" )
    public Uni<Response<Track>> getPlaylistTracks(@PathParam( "id" ) long id){
        return api.getPlaylistTracks(id)
                .map(mapper::spotifyTrackResponseToResponse);
    }

}
