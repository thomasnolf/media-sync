package com.tnolf;

import lombok.Data;

@Data
public class SyncModel {
    public String source;
    public String target;

    public String sourceId;
    public String targetId;

    public boolean createTargetIfNotExists;
}
