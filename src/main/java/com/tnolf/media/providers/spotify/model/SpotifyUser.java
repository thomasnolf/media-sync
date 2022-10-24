package com.tnolf.media.providers.spotify.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <pre>
 *    {
 *         "display_name": "tomtom",
 *         "external_urls": {
 *           "spotify": "https://open.spotify.com/user/zt6ydw1pueownntazvivzxl0k"
 *         },
 *         "href": "https://api.spotify.com/v1/users/zt6ydw1pueownntazvivzxl0k",
 *         "id": "zt6ydw1pueownntazvivzxl0k",
 *         "type": "user",
 *         "uri": "spotify:user:zt6ydw1pueownntazvivzxl0k"
 *       }
 * </pre>
 */
public class SpotifyUser {
    public String id;
    @JsonProperty( value = "display_name" )
    public String displayName;
}
