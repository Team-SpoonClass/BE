package com.likelion.spoonclass.domain.member.auth;

import com.likelion.spoonclass.common.BaseTest;
import com.likelion.spoonclass.common.DtoFactory;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;
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
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SignInTest extends BaseTest {
    @MockBean
    private AuthService authService;

    @Test
    @Transactional
    @DisplayName(value = "로그인 (성공 시)")
    void 로그인() throws Exception {

        given(authService.login(any(RequestAuthSignInDto.class))).willReturn(1L);

        mockMvc.perform(post("/auth/signIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(DtoFactory.getMockSignInDto())))
                .andExpect(status().isOk())
                .andDo(print())

                // docs
                .andDo(document("auth/signIn_success",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호")
                        ),
                        responseFields(
                                fieldWithPath("message").type(JsonFieldType.STRING).description("메시지"),
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("id")
                        )
                ));
    }

}