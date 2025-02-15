package com.inditex.demo.endpoint.interfaces;



import com.inditex.demo.endpoint.domain.PricesService;
import com.inditex.demo.endpoint.infrastructure.entity.Prices;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PricesController {

    private final PricesService pricesService;

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping("/applicable-price")
    public ResponseEntity<Prices> getApplicablePrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        Prices applicablePrice = pricesService.getApplicablePrice(brandId, productId, applicationDate);

        if (applicablePrice != null) {
            return ResponseEntity.ok(applicablePrice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}