package com.tnolf.deezer;

import lombok.ToString;

@ToString
public class DeezerFailure {
    public DeezerError error;

    public static class DeezerError {
        public String type;
        public String message;
        public int code;
    }
}
