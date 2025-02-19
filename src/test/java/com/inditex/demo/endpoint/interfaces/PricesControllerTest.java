package com.inditex.demo.endpoint.interfaces;



import com.inditex.demo.endpoint.domain.PricesService;
import com.inditex.demo.endpoint.infrastructure.entity.Prices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricesService pricesService;

    @Test
    public void test1_10amDay14() throws Exception {

        Prices expectedPrice = new Prices();
        expectedPrice.setBrandId(1L);
        expectedPrice.setProductId(35455L);
        expectedPrice.setPriceList(1L);
        expectedPrice.setStartDate(LocalDateTime.of(2020, 06, 14, 0, 0));
        expectedPrice.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        expectedPrice.setPrice(new BigDecimal("35.50"));
        expectedPrice.setCurr("EUR");

        when(pricesService.getApplicablePrice(eq(1L), eq(35455L), any(LocalDateTime.class)))
                .thenReturn(expectedPrice);

        mockMvc.perform(get("/prices/applicable-price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }

    @Test
    public void test2_4pmDay14() throws Exception {

        Prices expectedPrice = new Prices();
        expectedPrice.setBrandId(1L);
        expectedPrice.setProductId(35455L);
        expectedPrice.setPriceList(2L);
        expectedPrice.setStartDate(LocalDateTime.of(2020, 06, 14, 15, 0));
        expectedPrice.setEndDate(LocalDateTime.of(2020, 06, 14, 18, 30));
        expectedPrice.setPrice(new BigDecimal("25.45"));
        expectedPrice.setCurr("EUR");

        when(pricesService.getApplicablePrice(eq(1L), eq(35455L), any(LocalDateTime.class)))
                .thenReturn(expectedPrice);

        mockMvc.perform(get("/prices/applicable-price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }
    @Test
    public void test3_9pmDay14() throws Exception {
        Prices expectedPrice = new Prices();
        expectedPrice.setBrandId(1L);
        expectedPrice.setProductId(35455L);
        expectedPrice.setPriceList(1L);
        expectedPrice.setStartDate(LocalDateTime.of(2020, 06, 14, 0, 0));
        expectedPrice.setEndDate(LocalDateTime.of(2020, 06, 14, 23, 59, 59));
        expectedPrice.setPrice(new BigDecimal("35.50"));
        expectedPrice.setCurr("EUR");

        when(pricesService.getApplicablePrice(eq(1L), eq(35455L), any(LocalDateTime.class)))
                .thenReturn(expectedPrice);

        mockMvc.perform(get("/prices/applicable-price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }

    @Test
    public void test4_10amDay15() throws Exception {

        Prices expectedPrice = new Prices();
        expectedPrice.setBrandId(1L);
        expectedPrice.setProductId(35455L);
        expectedPrice.setPriceList(3L);
        expectedPrice.setStartDate(LocalDateTime.of(2020, 06, 15, 0, 0));
        expectedPrice.setEndDate(LocalDateTime.of(2020, 06, 15, 11, 0));
        expectedPrice.setPrice(new BigDecimal("30.50"));
        expectedPrice.setCurr("EUR");

        when(pricesService.getApplicablePrice(eq(1L), eq(35455L), any(LocalDateTime.class)))
                .thenReturn(expectedPrice);


        mockMvc.perform(get("/prices/applicable-price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-15T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.50))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }

    @Test
    public void test5_9pmDay16() throws Exception {

        Prices expectedPrice = new Prices();
        expectedPrice.setBrandId(1L);
        expectedPrice.setProductId(35455L);
        expectedPrice.setPriceList(4L);
        expectedPrice.setStartDate(LocalDateTime.of(2020, 06, 15, 21, 0));
        expectedPrice.setEndDate(LocalDateTime.of(2020, 06, 15, 23, 59, 59));
        expectedPrice.setPrice(new BigDecimal("38.95"));
        expectedPrice.setCurr("EUR");

        when(pricesService.getApplicablePrice(eq(1L), eq(35455L), any(LocalDateTime.class)))
                .thenReturn(expectedPrice);

        mockMvc.perform(get("/prices/applicable-price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }
}