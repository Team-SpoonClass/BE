package com.likelion.spoonclass.domain.lesson.api;

import com.likelion.spoonclass.common.BaseTest;
import com.likelion.spoonclass.common.DtoFactory;
import com.likelion.spoonclass.common.EntityFactory;
import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.dto.LessonDto;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.lesson.service.LessonService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.transaction.annotation.Transactional;

import static com.likelion.spoonclass.config.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LessonGetTest extends BaseTest {
    @MockBean
    private LessonService lessonService;

    @Test
    @Transactional
    void 한_클래스_가져오기() throws Exception {
        RequestLessonDto mockRequest = DtoFactory.getMockLessonDto();
        Lesson mockLesson = EntityFactory.getMockLesson(mockRequest);
        LessonDto mockLessonDto = DtoFactory.getMockLessonDto(mockLesson);

        given(lessonService.get(any(Long.class))).willReturn(mockLessonDto);

        mockMvc.perform(get("/lesson/one")
                        .param("id","1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())

                .andDo(document("/one_lesson_success",
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("message").type(JsonFieldType.STRING).description("메시지"),
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("클래스 id"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                fieldWithPath("oneLineInfo").type(JsonFieldType.STRING).description("한 줄 소개"),
                                fieldWithPath("openKakao").type(JsonFieldType.STRING).description("오픈 채팅방"),
                                fieldWithPath("club").type(JsonFieldType.STRING).description("동아리"),
                                fieldWithPath("representPath").type(JsonFieldType.STRING).description("이미지"),
                                fieldWithPath("description").type(JsonFieldType.STRING).description("설명"),
                                fieldWithPath("status").type(JsonFieldType.STRING).description("클래스 상태")

                                )
                ));
    }
}