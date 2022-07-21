package com.enterprise.coffee.Restful.API.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class GetCommunityResponse {
<<<<<<< HEAD:src/main/java/com/enterprise/coffee/Restful/API/response/GetCommunityResponse.java

    @JsonProperty("Communities")
=======
>>>>>>> fdade3b8756a36682f2a6720223c549f39d010ac:src/main/java/com/enterprise/coffee/Restful/API/model/GetCommunityResponse.java
    List<CommunityList> communities = new ArrayList<>();
}

