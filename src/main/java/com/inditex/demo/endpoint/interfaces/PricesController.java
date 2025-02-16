package com.inditex.demo.endpoint.interfaces;



import com.inditex.demo.endpoint.domain.PricesService;
import com.inditex.demo.endpoint.infrastructure.entity.Prices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
            @RequestParam String applicationDate) {

        LocalDateTime parsedDate;
        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            parsedDate = LocalDateTime.parse(applicationDate, formatter);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().build();
        }

        Prices applicablePrice = pricesService.getApplicablePrice(brandId, productId, parsedDate);

        if (applicablePrice != null) {
            return ResponseEntity.ok(applicablePrice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}