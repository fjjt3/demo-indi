package com.inditex.demo.endpoint.domain;

import com.inditex.demo.endpoint.infrastructure.PricesRepository;
import com.inditex.demo.endpoint.infrastructure.entity.Prices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/*@ExtendWith(MockitoExtension.class)
class PricesServiceTest {

    @Mock
    private PricesRepository pricesRepository;

    @InjectMocks
    private PricesService pricesService;


    @Test
    void shouldReturnProveedoresByIdCliente() {

        // GIVEN
        Prices prices1 = new Prices(1L, "Proveedor A", LocalDate.now(), 101L);
        Prices prices2 = new Prices(2L, "Proveedor B", LocalDate.now(), 101L);

        // WHEN
        when(pricesRepository.findByClientId(101L)).thenReturn(List.of(prices1, prices2));

        // THEN
        List<Prices> result = pricesService.obtenerProveedoresPorCliente(101L);

        assertThat(result).hasSize(2);
        assertThat(result).extracting("nombre").containsExactlyInAnyOrder("Proveedor A", "Proveedor B");
    }
}*/