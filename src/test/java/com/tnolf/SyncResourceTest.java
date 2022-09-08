package com.tnolf;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.with;

class SyncResourceTest {

    @Test
    void sync(){

        SyncModel syncModel = new SyncModel();
        syncModel.source = "deezer";
        syncModel.sourceId = "673929275";
        syncModel.target = "spotify";
        syncModel.targetId = "toto";
        with().body(syncModel)
                .when()
                .request("POST", "/sync")
                .then()
                .statusCode(201);
    }
}