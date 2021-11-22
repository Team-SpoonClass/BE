package com.likelion.spoonclass.domain.lesson.api;

import com.likelion.spoonclass.common.BaseTest;
import com.likelion.spoonclass.common.DtoFactory;
import com.likelion.spoonclass.config.auth.MockMember;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.lesson.service.LessonService;
import com.likelion.spoonclass.domain.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static com.likelion.spoonclass.config.ApiDocumentUtils.getDocumentRequest;
import static com.likelion.spoonclass.config.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LessonModifyTest extends BaseTest {

    @MockBean
    private LessonService lessonService;

    @Test
    @MockMember
    @DisplayName(value = "클래스 수정 성공")
    void modify() throws Exception {
        given(lessonService.modify(any(Member.class),any(Long.class),any(RequestLessonDto.class)))
                .willReturn(1L);

        mockMvc.perform(post("/lesson/modify")
                .param("id","1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(DtoFactory.getMockLessonDto())))
                .andExpect(status().isOk())
                .andDo(print())

                .andDo(document("/lesson/modify_success",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("name").type(JsonFieldType.STRING).description("클래스 이름"),
                                fieldWithPath("oneLineInfo").type(JsonFieldType.STRING).description("한 줄 소개"),
                                fieldWithPath("description").type(JsonFieldType.STRING).description("설명"),
                                fieldWithPath("club").type(JsonFieldType.STRING).description("동아리"),
                                fieldWithPath("openKakao").type(JsonFieldType.STRING).description("오픈 채팅방")
                        ),
                        responseFields(
                                fieldWithPath("message").type(JsonFieldType.STRING).description("메시지"),
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("클래스 id")
                        )
                ));
    }
}