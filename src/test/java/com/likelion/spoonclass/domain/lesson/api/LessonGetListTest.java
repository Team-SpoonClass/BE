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
                                fieldWithPath("message").type(JsonFieldType.STRING).description("?????????"),
                                fieldWithPath("lessonDetailDto.[].id").type(JsonFieldType.NUMBER).description("????????? id"),
                                fieldWithPath("lessonDetailDto.[].name").type(JsonFieldType.STRING).description("????????? ??????"),
                                fieldWithPath("lessonDetailDto.[].club").type(JsonFieldType.STRING).description("?????????"),
                                fieldWithPath("lessonDetailDto.[].oneLineInfo").type(JsonFieldType.STRING).description("??? ??? ??????"),
                                fieldWithPath("lessonDetailDto.[].representPath").type(JsonFieldType.STRING).description("?????? ????????? ??????"),
                                fieldWithPath("lessonDetailDto.[].status").type(JsonFieldType.STRING).description("????????? ?????? ??????")
                        )));
    }
}