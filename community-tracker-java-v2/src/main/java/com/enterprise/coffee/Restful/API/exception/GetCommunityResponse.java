package com.enterprise.coffee.Restful.API.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class GetCommunityResponse {

    List<CommunityList> communities = new ArrayList<>();
}

