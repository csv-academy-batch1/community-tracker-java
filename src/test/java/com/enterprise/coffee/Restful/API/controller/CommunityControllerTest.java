//package com.enterprise.coffee.Restful.API.controller;
//
//import com.enterprise.coffee.Restful.API.mapper.OutputCommunityMap;
//import com.enterprise.coffee.Restful.API.model.Community;
//import com.enterprise.coffee.Restful.API.service.CommunityService;
//import com.enterprise.coffee.Restful.API.service.ManagerService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(value = CommunityController.class)
//@AutoConfigureMockMvc
//@WithMockUser
//public class CommunityControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private CommunityService communityService;
//
//    @MockBean
//    private ManagerService managerService;
//
//    @MockBean
//    private OutputCommunityMap communityMap;
//
//
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    @Test
//    @DisplayName("Given a successful save, response should give http status 2xx")
//    public void success() throws Exception {
//
//        Community communityRequest = new Community("Enterprise Coffee Latte",100L,"Java Developer");
//        String exampleCommunityJson ="{\"communityId\":283,\"communityName\":\"EnterpriseCoffeeTEST1000\",\"communityManagerName\":\"Administrator2\",\"communityDesc\":\"Description1000.\"}";
//
//        Mockito.when(communityService.createCommunity(Mockito.any(Community.class))).thenReturn(communityRequest);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/community")
//                .accept(MediaType.APPLICATION_JSON)
//                .content(exampleCommunityJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//    }
//
////    @Test
////    @DisplayName("Given a successful save, response should give http status 2xx")
////    public void success() throws Exception {
////
////        Community communityRequest = new Community("Enterprise Coffee Latte",100L,"Java Developer");
////        this.mockMvc.perform(post("/community").content(
////                objectMapper.writeValueAsString(communityRequest)
////        ).contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().is2xxSuccessful());
////
////        verify(communityService)
////                .createCommunity(communityRequest);
////    }
//}
