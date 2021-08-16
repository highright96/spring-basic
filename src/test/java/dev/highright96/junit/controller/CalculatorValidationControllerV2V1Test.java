package dev.highright96.junit.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.highright96.junit.component.CalculatorService;
import dev.highright96.junit.component.MarketApi;
import dev.highright96.junit.dto.Req;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CalculatorApiController.class)
class CalculatorApiControllerTest {

    @MockBean
    private MarketApi marketApi;

    @MockBean
    private CalculatorService calculatorService;

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void sumTest() throws Exception {
        when(marketApi.connect()).thenReturn(100);
        when(calculatorService.sum(anyInt(), anyInt())).thenReturn(3000);

        mockMvc.perform(get("/api/sum")
                .queryParam("x", "10")
                .queryParam("y", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("3000"))
                .andDo(print());
    }

    @Test
    void minusTest() throws Exception {

        Req req = new Req(10, 10);

        when(marketApi.connect()).thenReturn(100);
        when(calculatorService.minus(anyInt(), anyInt())).thenReturn(3000);

        mockMvc.perform(post("/api/minus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(content().string("3000"))
                .andDo(print());
    }
}