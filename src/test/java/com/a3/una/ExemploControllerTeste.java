package com.a3.una;

import com.a3.una.models.ExemploEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExemploControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSave() throws Exception {
        ExemploEntity entity = new ExemploEntity();
        entity.setNome("teste");
        entity.setDescricao("Descrição do exemplo");

        String json = objectMapper.writeValueAsString(entity);

        mockMvc.perform(MockMvcRequestBuilders.post("/exemplo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("teste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value("Descrição do exemplo"));
    }
}