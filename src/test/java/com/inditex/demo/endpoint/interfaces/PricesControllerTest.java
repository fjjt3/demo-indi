package com.inditex.demo.endpoint.interfaces;

import com.inditex.demo.endpoint.domain.PricesService;
import com.inditex.demo.endpoint.infrastructure.entity.Prices;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PricesController.class)
class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricesService pricesService;

    @Test
    void shouldReturnProveedoresForGivenIdCliente() throws Exception {

        // GIVEN
        Prices prices1 = new Prices(1L, "Proveedor A", LocalDate.now(), 101L);
        Prices prices2 = new Prices(2L, "Proveedor B", LocalDate.now(), 101L);

        // WHEN
        when(pricesService.obtenerProveedoresPorCliente(101L)).thenReturn(List.of(prices1, prices2));

        // THEN
        mockMvc.perform(get("/proveedores/101"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nombre").value("Proveedor A"))
                .andExpect(jsonPath("$[1].nombre").value("Proveedor B"));
    }
}

