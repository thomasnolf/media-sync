package com.tnolf.media.providers.deezer.api.model;

import lombok.ToString;

@ToString
public class DeezerFailure {
    public DeezerError error;

    @ToString
    public static class DeezerError {
        public String type;
        public String message;
        public int code;
    }
}
