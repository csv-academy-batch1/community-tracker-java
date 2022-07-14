package com.community.Community.Management.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class CommunityDTO {

    private Long communityId;

    private String communityName;

    private int communityManagerId;

    private String communityDesc;

}
