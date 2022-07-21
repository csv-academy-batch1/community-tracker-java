package com.enterprise.coffee.Restful.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class CreateCommunityResponse {
    @JsonProperty("CommunityId")
    private Long communityId;
    @JsonProperty("CommunityName")
    private String communityName;
    @JsonProperty("CommunityManager")
    private String communityManagerName;
    @JsonProperty("Description")
    private String communityDesc;
    @JsonProperty("Active")
    private Boolean isActive;
}
