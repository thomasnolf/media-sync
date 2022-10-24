package com.tnolf.rest.mapper;

import com.tnolf.media.providers.spotify.model.SpotifyPlaylist;
import com.tnolf.media.providers.spotify.model.SpotifyResponse;
import com.tnolf.media.providers.spotify.model.SpotifyTrack;
import com.tnolf.rest.model.Playlist;
import com.tnolf.rest.model.Response;
import com.tnolf.rest.model.Track;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class SpotifyMapper {

    public static Response<Playlist> spotifyPlaylistResponseToPlaylistResponse(SpotifyResponse<SpotifyPlaylist> spotifyResponse){
        return new Response<>(spotifyResponse.items.stream()
                .map(p -> new Playlist(p.id, p.name))
                .collect(Collectors.toCollection(LinkedHashSet::new)), spotifyResponse.total);
    }

    public static Response<Track> spotifyTrackResponseToTrackResponse(SpotifyResponse<SpotifyTrack> spotifyResponse){
        return new Response<>(spotifyResponse.items.stream()
                .map(p -> new Track(p.id, p.name, p.isrc))
                .collect(Collectors.toCollection(LinkedHashSet::new)), spotifyResponse.total);
    }

}
