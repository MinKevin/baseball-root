package com.baseball_root.member.controller;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @LocalServerPort
    private int port;

    private String prefix;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();

        prefix = "http://localhost:";
    }

    @Test
    void 회원_정보_추가() throws Exception {
        // given
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nickname", "test_nickname");
        jsonObject.put("favorite_team", "test_favorite_team");
        jsonObject.put("profile_image", "test_profile_image");

        // when
        MvcResult mvcResult = mockMvc.perform(
                        post(prefix + "/members")
                                .content(jsonObject.toJSONString())
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andReturn();

        // then
        for (String key : jsonObject.keySet()) {
            assertEquals(
                    jsonObject.get(key),
                    JsonPath.parse(mvcResult.getResponse().getContentAsString()).read("$.data." + key)
            );
        }
    }

    @Test
    void 회원_정보_수정() throws Exception {
        // given
        JSONObject newMemberInfo = new JSONObject();
        newMemberInfo.put("nickname", "test_nickname");
        newMemberInfo.put("favorite_team", "test_favorite_team");
        newMemberInfo.put("profile_image", "test_profile_image");

        MvcResult mvcResult = mockMvc.perform(
                post(prefix + "/members")
                        .content(newMemberInfo.toJSONString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        String memberId = JsonPath.parse(mvcResult.getResponse().getContentAsString()).read("$.data." + "id");
        JSONObject updateMemberInfo = new JSONObject();
        updateMemberInfo.put("nickname", "updated_nickname");
        updateMemberInfo.put("favorite_team", "updated_favorite_team");
        updateMemberInfo.put("profile_image", "updated_profile_image");

        // when
        mvcResult = mockMvc.perform(
                        patch(prefix + "/members?id=" + memberId)
                                .content(updateMemberInfo.toJSONString())
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andReturn();

        // then
        for (String key : updateMemberInfo.keySet()) {
            assertEquals(
                    updateMemberInfo.get(key),
                    JsonPath.parse(mvcResult.getResponse().getContentAsString()).read("$.data." + key)
            );
        }
    }

}