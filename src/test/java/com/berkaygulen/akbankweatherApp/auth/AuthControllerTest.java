package com.berkaygulen.akbankweatherApp.auth;

import com.berkaygulen.akbankweatherApp.AkbankWeatherAppApplication;
import com.berkaygulen.akbankweatherApp.BaseTest;
import com.berkaygulen.akbankweatherApp.auth.dto.LoginRequestDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {AkbankWeatherAppApplication.class})
class AuthControllerTest extends BaseTest {

    private static final String BASE_PATH = "/api/v1/auth";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    void shouldLogin() throws Exception {
        LoginRequestDTO loginRequestDTO =
                new LoginRequestDTO("berkay@gmail.com","berkay123");

        String body = objectMapper.writeValueAsString(loginRequestDTO);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post(BASE_PATH)
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertTrue(success);
    }

    @Test
    void shouldNotLoginWhenPasswordIsWrong() throws Exception {
        LoginRequestDTO loginRequestDTO =
                new LoginRequestDTO("berkay@gmail.com","1231234");

        String body = objectMapper.writeValueAsString(loginRequestDTO);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post(BASE_PATH)
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().is(401))
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertFalse(success);

    }

    @Test
    void shouldNotLoginWhenEmailNotFound() throws Exception {
        LoginRequestDTO loginRequestDTO =
                new LoginRequestDTO("wrong@gmail.com","1231234");

        String body = objectMapper.writeValueAsString(loginRequestDTO);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post(BASE_PATH)
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().is(401))
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertFalse(success);

    }
}