package com.likelion.spoonclass.domain.lesson.api;

import com.likelion.spoonclass.common.BaseTest;
import com.likelion.spoonclass.config.auth.MockMember;
import com.likelion.spoonclass.domain.lesson.service.LessonService;
import com.likelion.spoonclass.domain.member.Member;
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
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LessonCloseTest extends BaseTest {
    @MockBean
    private LessonService lessonService;

    @Test
    @MockMember
    @Transactional
    void close() throws Exception{
        given(lessonService.close(any(Member.class),any(Long.class))).willReturn(1L);

        mockMvc.perform(post("/lesson/close").param("id","1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())

                .andDo(document("/lesson/close_success",
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("message").type(JsonFieldType.STRING).description("메시지")
                        )
                ));
    }
}