package com.tnolf.rest;

import com.tnolf.media.providers.spotify.model.SpotifyPlaylist;
import com.tnolf.media.providers.spotify.model.SpotifyResponse;
import com.tnolf.media.providers.spotify.model.SpotifyTrack;
import com.tnolf.media.providers.spotify.model.SpotifyUser;
import com.tnolf.rest.model.Playlist;
import com.tnolf.rest.model.Response;
import com.tnolf.rest.model.Track;
import com.tnolf.rest.model.User;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@org.mapstruct.Mapper(componentModel = "cdi")
public interface MyMapper {

    Response<Playlist> spotifyPlayListResponseToResponse(SpotifyResponse<SpotifyPlaylist> spotifyResponse);
    Response<Track> spotifyTrackResponseToResponse(SpotifyResponse<SpotifyTrack> spotifyTrack);

    default Set<Playlist> spotifyPlaylistSetToPlaylists(Set<SpotifyPlaylist> spotifyPlaylists) {
        return spotifyPlaylists.stream()
                .map(this::spotifyPlaylistToPlaylist)
                .collect(Collectors.toSet());
    }

    Playlist spotifyPlaylistToPlaylist(SpotifyPlaylist spotifyPlaylist);

    User spotifyUserToUser(SpotifyUser user);
    Track spotifyTrackToUser(SpotifyTrack track);
}
