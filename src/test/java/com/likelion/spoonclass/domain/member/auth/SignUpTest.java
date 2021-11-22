package com.likelion.spoonclass.domain.member.auth;

import com.likelion.spoonclass.common.BaseTest;
import com.likelion.spoonclass.common.DtoFactory;
import com.likelion.spoonclass.common.EntityFactory;
import com.likelion.spoonclass.domain.member.Member;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;
import com.likelion.spoonclass.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SignUpTest extends BaseTest {
    @MockBean
    private AuthService authService;

    @Test
    @Transactional
    @DisplayName(value = "회원가입 테스트 (성공 시)")
    void 회원가입() throws Exception {
        RequestAuthSignUpDto requestDto = DtoFactory.getMockSignUpDto();

        given(authService.join(any(RequestAuthSignUpDto.class))).willReturn(1L);

        mockMvc.perform(post("/auth/signUp")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andDo(print())

                // docs
                .andDo(document("auth/signUp_success",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                fieldWithPath("univ").type(JsonFieldType.STRING).description("대학교")
                        ),
                        responseFields(
                                fieldWithPath("message").type(JsonFieldType.STRING).description("메시지"),
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("id")
                        )
                ));

    }
}