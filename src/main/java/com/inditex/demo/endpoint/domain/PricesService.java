package com.inditex.demo.endpoint.domain;


import com.inditex.demo.endpoint.infrastructure.entity.Prices;
import com.inditex.demo.endpoint.infrastructure.PricesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PricesService {

    private final PricesRepository pricesRepository;

    public PricesService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public Prices getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        List<Prices> prices = pricesRepository.findApplicablePrice(brandId, productId, applicationDate);
        return prices.isEmpty() ? null : prices.get(0); // Devuelve el primer resultado (el de mayor prioridad)
    }
}