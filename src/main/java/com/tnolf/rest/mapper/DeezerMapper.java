package com.tnolf.rest.mapper;

import com.tnolf.media.providers.deezer.api.model.DeezerPlaylist;
import com.tnolf.media.providers.deezer.api.model.DeezerResponse;
import com.tnolf.media.providers.deezer.api.model.DeezerTrack;
import com.tnolf.rest.model.Playlist;
import com.tnolf.rest.model.Response;
import com.tnolf.rest.model.Track;

import java.util.stream.Collectors;

public class DeezerMapper {

    public static Response<Playlist> deezerPlaylistResponseToPlaylistResponse(DeezerResponse<DeezerPlaylist> deezerResponse){
        return new Response<>(deezerResponse.data.stream()
                .map(p -> new Playlist(String.valueOf(p.id), p.title))
                .collect(Collectors.toSet()), deezerResponse.total);
    }

    public static Response<Track> deezerTrackResponseToTrackResponse(DeezerResponse<DeezerTrack> deezerResponse){
        return new Response<>(deezerResponse.data.stream()
                .map(p -> new Track(String.valueOf(p.id), p.title, p.isrc))
                .collect(Collectors.toSet()), deezerResponse.total);
    }

}
