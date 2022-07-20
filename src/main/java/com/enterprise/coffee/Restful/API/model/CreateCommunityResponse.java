package com.enterprise.coffee.Restful.API.model;

import lombok.Data;
@Data
public class CreateCommunityResponse {

    private Long communityId;

    private String communityName;

    private String communityManagerName;

    private String communityDesc;

    private Boolean isActive;

}
