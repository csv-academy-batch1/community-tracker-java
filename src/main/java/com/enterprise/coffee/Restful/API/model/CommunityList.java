package com.enterprise.coffee.Restful.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CommunityList {
    @JsonProperty("CommunityId")
    private Long communityId;
    @JsonProperty("CommunityName")
    private String communityName;
    @JsonProperty("CommunityMgrId")
    private Long communityMgrId;
    @JsonProperty("Description")
    private String description;
}
