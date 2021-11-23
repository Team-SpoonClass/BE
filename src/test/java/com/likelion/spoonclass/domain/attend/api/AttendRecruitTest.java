package com.likelion.spoonclass.domain.attend.api;

import com.likelion.spoonclass.common.BaseTest;
import com.likelion.spoonclass.common.DtoFactory;
import com.likelion.spoonclass.common.EntityFactory;
import com.likelion.spoonclass.config.auth.MockMember;
import com.likelion.spoonclass.domain.attend.Attend;
import com.likelion.spoonclass.domain.attend.service.AttendService;
import com.likelion.spoonclass.domain.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.transaction.annotation.Transactional;

import static com.likelion.spoonclass.config.ApiDocumentUtils.getDocumentRequest;
import static com.likelion.spoonclass.config.ApiDocumentUtils.getDocumentResponse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AttendRecruitTest extends BaseTest {
    @MockBean
    private AttendService attendService;

    @Test
    @MockMember
    @Transactional
    @DisplayName(value = "동아리 가입 성공")
    void 클래스가입() throws Exception {

        given(attendService.recruit(any(Member.class), any(Long.class)))
                .willReturn(EntityFactory.getMockAttend());

        mockMvc.perform(post("/lesson/attend")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id","1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("/lesson/attend_success",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("message").type(JsonFieldType.STRING).description("메시지"),
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("클래스 id"),
                                fieldWithPath("openKakao").type(JsonFieldType.STRING).description("오픈 카카오")
                        )
                ));
    }
}