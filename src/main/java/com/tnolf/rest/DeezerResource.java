package com.tnolf.rest;

import com.tnolf.media.providers.deezer.api.client.DeezerApiClient;
import com.tnolf.media.providers.deezer.api.model.DeezerResponse;
import com.tnolf.media.providers.deezer.api.model.DeezerPlaylist;
import com.tnolf.media.providers.deezer.api.model.DeezerTrack;
import com.tnolf.media.providers.deezer.api.model.DeezerUser;
import com.tnolf.rest.mapper.DeezerMapper;
import com.tnolf.rest.model.Playlist;
import com.tnolf.rest.model.Response;
import com.tnolf.rest.model.Track;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestHeader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/deezer")
public class DeezerResource {

    @RestClient
    DeezerApiClient api;

    @GET
    @Path("me")
    public Uni<DeezerUser> getUserInfo(){

        return api.getUserInfo();
    }

    @GET
    @Path("playlists")
    public Uni<Response<Playlist>> getUserPlaylists(){

        return api.getUserPlaylists()
                .map(DeezerMapper::deezerPlaylistResponseToPlaylistResponse);
    }

    @GET
    @Path("playlist/{id}/tracks")
    public Uni<Response<Track>> getPlaylistTracks(@PathParam("id") long id){

        return api.getPlaylistTracks(id)
                .map(DeezerMapper::deezerTrackResponseToTrackResponse);
    }

}
