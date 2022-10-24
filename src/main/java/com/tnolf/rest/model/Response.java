package com.tnolf.rest.model;

import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class Response<T> {

    public Set<T> items;
    public int total;
}
