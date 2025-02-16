package com.inditex.demo.endpoint.infrastructure;

import com.inditex.demo.endpoint.infrastructure.entity.Prices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*@DataJpaTest
class PricesRepositoryTest {

    @Autowired
    private PricesRepository pricesRepository;

    @Test
    void shouldFindProveedoresByIdCliente() {

        // WHEN
        List<Prices> result = pricesRepository.findByClientId(5L);

        // THEN
        assertThat(result).hasSize(2);
    }
}*/