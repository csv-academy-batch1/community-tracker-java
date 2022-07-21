package com.enterprise.coffee.Restful.API.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class CreateCommunityResponse {

    @JsonProperty("CommunityId")
    private Long CommunityId;

    @JsonProperty("CommunityName")
    private String communityName;

    @JsonProperty("CommunityManager")
    private String communityManager;

    @JsonProperty("Description")
    private String communityDesc;

    @JsonProperty("Active")
    private Boolean isActive;

}
