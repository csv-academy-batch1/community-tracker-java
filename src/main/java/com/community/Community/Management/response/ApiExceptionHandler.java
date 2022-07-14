package com.community.Community.Management.response;

import com.community.Community.Management.model.Community;
import com.community.Community.Management.model.CommunityDTO;
import com.community.Community.Management.model.CommunityManager;
import com.community.Community.Management.service.CommunityManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.LinkedHashMap;
import java.util.Map;
public class ApiExceptionHandler {

    public static ResponseEntity<Object> negativeResponse(Object objectMessage, HttpStatus status) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result:", objectMessage);
        return new ResponseEntity<>(map,status);
    }

    public static ResponseEntity<Object> positiveResponse(Community communityObject, CommunityManager communityManagerObject, HttpStatus status) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("Community Id:", communityObject.getCommunityId());
        map.put("Community Name:", communityObject.getCommunityName());
        map.put("Community Manager:", communityManagerObject.getCommunityManagerName());
        map.put("Description:", communityObject.getCommunityDesc());

        return new ResponseEntity<>(map,status);
    }

}
