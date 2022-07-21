package com.enterprise.coffee.Restful.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class CreateCommunityResponse {
    @JsonProperty("Community Id")
    private Long communityId;
    @JsonProperty("Community Name")
    private String communityName;
    @JsonProperty("Community Manager")
    private String communityManagerName;
    @JsonProperty("Description")
    private String communityDesc;
    @JsonProperty("Active")
    private Boolean isActive;
}
