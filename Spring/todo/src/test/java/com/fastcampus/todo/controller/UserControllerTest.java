package com.fastcampus.todo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fastcampus.todo.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootTest
class UserControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // 웹 정확도: 브라우저테슽 > 호출테스트(.http) > mockmvc 테스트
    // RestApi 정확도 : 브라우저테스트 = 호출테스트 > mockmvc 테스트
    // 편리성 : mockmvc 테스트 > 호출테스트 > 브라우저테스트
    // 브라우저 100% x 1 vs 99% mock테스트 x 100
    // 브라우저 0%

    // 브라우저테스트 -> 체크리스트
    // .http 테스트 -> curl, httpie, swagger
    // MockMvc 테스트 -> Spring 테스트
    // Mock 테스트

    // 오류 (장애)
    // 컴파일 에러 -> 테스트 에러 -> Springboot run 에러 (runtime)
    // -> 브라우저, 실환경 runtime에러 -> runtime 논리적인 에러
    // 자바에서 `다중상속`

    // Feedback -> 학습(Agile) : 빠를수록 좋다

    // 테스트는 반드시 에러가 나야함
    // 테스트는 1곳에서만 에러가 나야함 (=최소한의 범위에서만 에러)
    // SRP(Single Response Principle)

    // json -> 데이터 규격
    // ajax -> 통신규격
    // frontend - backend 데이터 통신(json)
    // csr(client side rendering) : 작게 여러번 통신
    // js 파일 <- 템플릿(js) -> 정적파일
    // ssr(server side rendering) : 크게 한번에 통신. 페이지가 통으로 로딩되어서 느림
    //  -> MSA micro service archetecture
    // jsp, servlet -> ssr

    // frontend 협업
    // ModelAndView ??
    // 데이터 + servlet(데이터 + 뷰) + jsp (데이터 / 뷰)
    // freemaker, thymeleaf -> 템플릿 엔진, jsp 와 비슷함. view에 대한 템플릿
    // backend -> 데이터 담당 (api 제공) -> json 결과물
    // frontend -> 뷰 담당 -> ajax -> api 호출 -> json
    //


    @BeforeEach
    void before(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .alwaysDo(print())
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @DisplayName("Get유저")
    @Test
    void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("martin"))
                .andExpect(jsonPath("$.email").value("martin@fastcampus.com"));
    }

    @Test
    void getUserByEmail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/user?email=martin@fastcampus.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].id").value(1L))
                .andExpect(jsonPath("$.[0].name").value("martin"))
                .andExpect(jsonPath("$.[0].email").value("martin@fastcampus.com"));
    }

    @Test
    void getUserByEmailIfThrown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/user/?email="))
                .andExpect(status().isOk());
    }

    @DisplayName("Post유저")
    @Test
    void postUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(
                        objectMapper.writeValueAsString(
                                new UserDto("martin", "martin@fastcampus.com", "seoul", "password"))))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/3"))
                .andExpect(status().isOk());
    }
}
