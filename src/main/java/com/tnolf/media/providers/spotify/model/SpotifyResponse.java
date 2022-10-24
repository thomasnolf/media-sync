package com.tnolf.media.providers.spotify.model;

import java.util.Set;

/**
 * <pre>
 *    "limit": 20,
 *   "next": "https://api.spotify.com/v1/me/shows?offset=1&limit=1",
 *   "offset": 0,
 *   "previous": "https://api.spotify.com/v1/me/shows?offset=1&limit=1",
 *   "total": 4
 * </pre>
 * @param <T>
 */
public class SpotifyResponse<T> {
    public Set<T> items;
    public int limit;
    public String next;
    public String previous;
    public int offset;
    public int total;
}
