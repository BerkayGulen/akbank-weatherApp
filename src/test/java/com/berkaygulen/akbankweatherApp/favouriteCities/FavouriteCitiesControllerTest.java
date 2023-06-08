package com.berkaygulen.akbankweatherApp.favouriteCities;

import com.berkaygulen.akbankweatherApp.AkbankWeatherAppApplication;
import com.berkaygulen.akbankweatherApp.BaseTest;
import com.berkaygulen.akbankweatherApp.favouriteCities.dto.FavouriteCitiesSaveOrDeleteRequestDTO;
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
class FavouriteCitiesControllerTest extends BaseTest {
    private static final String BASE_PATH = "/api/v1/favourites";

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
        FavouriteCitiesSaveOrDeleteRequestDTO request = new FavouriteCitiesSaveOrDeleteRequestDTO(1003L,"Istanbul");

        String body = objectMapper.writeValueAsString(request);

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
    void shouldGetFavourites() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(BASE_PATH + "/1000")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertTrue(success);
    }

    @Test
    void shouldRemove() throws Exception {
        FavouriteCitiesSaveOrDeleteRequestDTO request = new FavouriteCitiesSaveOrDeleteRequestDTO(1001L,"London");
        String body = objectMapper.writeValueAsString(request);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.delete(BASE_PATH + "/delete")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertTrue(success);
    }
}