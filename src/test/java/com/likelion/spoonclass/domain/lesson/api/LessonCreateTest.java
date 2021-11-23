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
import org.springframework.transaction.annotation.Transactional;

import static com.likelion.spoonclass.config.ApiDocumentUtils.getDocumentRequest;
import static com.likelion.spoonclass.config.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LessonCreateTest extends BaseTest {
    @MockBean
    private LessonService lessonService;

    @Test
    @MockMember
    @Transactional
    @DisplayName(value = "로그인 성공")
    void create() throws Exception{
        given(lessonService.create(any(Member.class),any(RequestLessonDto.class)))
                .willReturn(1L);

        mockMvc.perform(post("/lesson/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(DtoFactory.getMockLessonDto())))
                .andExpect(status().isOk())
                .andDo(print())

                .andDo(document("lesson/create_success",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("name").type(JsonFieldType.STRING).description("클래스 이름"),
                                fieldWithPath("oneLineInfo").type(JsonFieldType.STRING).description("한 줄 요약"),
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