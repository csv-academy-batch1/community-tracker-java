package com.enterprise.coffee.Restful.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class GetCommunityResponse {

    @JsonProperty("Communities")
    List<CommunityList> communities = new ArrayList<>();
}

