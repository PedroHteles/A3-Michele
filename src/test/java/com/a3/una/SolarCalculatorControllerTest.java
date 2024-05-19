package com.a3.una;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.a3.una.controller.SolarCalculatorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
public class SolarCalculatorControllerTest {

    @Autowired
    private SolarCalculatorController controller;

    private MockMvc mockMvc;

    @Test
    public void testCalculatePanels() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Define test data
        Double consumoMensal = 200.0;
        Double valorKwh = 0.5;
        Double horasSolDia = 5.0;
        Double expectedPanels = 5.0;

        // Build the request URL
        String url = UriComponentsBuilder.fromPath("/painel/calculate")
                .queryParam("consumoMensal", consumoMensal)
                .queryParam("valorKwh", valorKwh)
                .queryParam("horasSolDia", horasSolDia)
                .toUriString();

        // Perform the test call
        String response = mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andReturn().getResponse().getContentAsString();

        // Assert the expected result
        assertEquals("Número de painéis solares de 150W: " + expectedPanels, response);
    }
}
