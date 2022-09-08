package com.tnolf;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/sync")
public class SyncResource {

    @Inject
    @Channel("sync-playlist")
    Emitter<SyncModel> emitter;

    @POST
    public void sync(SyncModel model){

        emitter.send(model);

    }
}