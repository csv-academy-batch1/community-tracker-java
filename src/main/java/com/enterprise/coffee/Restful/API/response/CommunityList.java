package com.enterprise.coffee.Restful.API.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CommunityList {

    @JsonProperty("CommunityId")
    private Long communityId;

    @JsonProperty("CommunityName")
    private String communityName;
}
