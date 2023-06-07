package com.berkaygulen.akbankweatherApp.weatherAPI;

import com.berkaygulen.akbankweatherApp.AkbankWeatherAppApplication;
import com.berkaygulen.akbankweatherApp.BaseTest;
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
class WeatherControllerTest extends BaseTest {

    private static final String BASE_PATH = "/api/v1/weather";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }


    @Test
    void shouldGetWeatherForecast() throws Exception {

        String cityName = "London";
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(BASE_PATH+"/forecast/"+cityName)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertTrue(success);

    }
    @Test
    void shouldNotGetWeatherForecastWhenCityIsNotFound() throws Exception {

        String cityName = "asdfasdf";
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(BASE_PATH+"/forecast/"+cityName)
                ).andExpect(MockMvcResultMatchers.status().is(404))
                .andReturn();

        boolean success = isSuccess(mvcResult);

        assertFalse(success);

    }
}