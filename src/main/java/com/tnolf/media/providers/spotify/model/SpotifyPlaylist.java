package com.tnolf.media.providers.spotify.model;

/**
 * <pre>
 *     {
 *       "collaborative": false,
 *       "id": "6VjXfabP2NQcTyHDxq180s",
 *       "name": "La drum et la bass",
 *       "owner": {@link SpotifyUser},
 *       "tracks": {
 *         "href": "https://api.spotify.com/v1/playlists/6VjXfabP2NQcTyHDxq180s/tracks",
 *         "total": 1
 *       },
 *       "type": "playlist",
 *       "uri": "spotify:playlist:6VjXfabP2NQcTyHDxq180s"
 *     }
 * </pre>
 */
public class SpotifyPlaylist {
    public String id;
    public String name;
}
