package com.berkaygulen.akbankweatherApp.user;

import com.berkaygulen.akbankweatherApp.AkbankWeatherAppApplication;
import com.berkaygulen.akbankweatherApp.BaseTest;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserUpdateRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
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
class UserControllerTest extends BaseTest {

    private static final String BASE_PATH = "/api/v1/users";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    void shouldSave() throws Exception {
        UserSaveRequestDTO userSaveRequestDTO =
                new UserSaveRequestDTO("berkay","gulen","berkay","berkay@gmail.com","1231234");

        String body = objectMapper.writeValueAsString(userSaveRequestDTO);

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
    void shouldFindAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(BASE_PATH)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertTrue(success);
    }

    @Test
    void shouldFindById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(BASE_PATH + "/1000")
                        //.param("id", "18") TODO: control
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertTrue(success);
    }

    @Test
    void shouldDelete() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.delete(BASE_PATH + "/1001")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertTrue(success);
    }

    @Test
    void shouldUpdate() throws Exception {
        UserUpdateRequestDTO userUpdateRequestDTO =
                new UserUpdateRequestDTO("berkay","gulen","berkay123","berkay123@gmail.com");

        String body = objectMapper.writeValueAsString(userUpdateRequestDTO);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.put(BASE_PATH+"/1002")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertTrue(success);
    }
}