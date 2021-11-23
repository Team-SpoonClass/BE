package com.likelion.spoonclass.domain.lesson.api;

import com.likelion.spoonclass.common.BaseTest;
import com.likelion.spoonclass.common.DtoFactory;
import com.likelion.spoonclass.common.EntityFactory;
import com.likelion.spoonclass.config.auth.MockMember;
import com.likelion.spoonclass.domain.lesson.dto.LessonDetailDto;
import com.likelion.spoonclass.domain.lesson.dto.ResponseLessonDto;
import com.likelion.spoonclass.domain.lesson.service.LessonService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.likelion.spoonclass.config.ApiDocumentUtils.getDocumentResponse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LessonGetListTest extends BaseTest {
    @MockBean
    private LessonService lessonService;

    @Test
    @MockMember
    @Transactional(readOnly = true)
    void getList() throws Exception{
        List<LessonDetailDto> list = new ArrayList<>();

        list.add(DtoFactory.getMockLessonDetailDto());
        list.add(DtoFactory.getMockLessonDetailDto());
        list.add(DtoFactory.getMockLessonDetailDto());

        given(lessonService.getList(any(Pageable.class)))
                .willReturn(list);

        mockMvc.perform(get("/lesson")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("/lesson_success",
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("message").type(JsonFieldType.STRING).description("메시지"),
                                fieldWithPath("lessonDetailDto.[].id").type(JsonFieldType.NUMBER).description("클래스 id"),
                                fieldWithPath("lessonDetailDto.[].name").type(JsonFieldType.STRING).description("클래스 이름"),
                                fieldWithPath("lessonDetailDto.[].club").type(JsonFieldType.STRING).description("동아리"),
                                fieldWithPath("lessonDetailDto.[].oneLineInfo").type(JsonFieldType.STRING).description("한 줄 소개"),
                                fieldWithPath("lessonDetailDto.[].representPath").type(JsonFieldType.STRING).description("대표 이미지 링크")
                        )));
    }
}