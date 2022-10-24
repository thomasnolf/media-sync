package com.tnolf.media.providers.deezer.api.model;

import java.util.List;

public class DeezerResponse<T> {
    public List<T> data;
    public String next;
    public String previous;
    public int total;
}
