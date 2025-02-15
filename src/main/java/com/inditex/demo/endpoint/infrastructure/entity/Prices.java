package com.inditex.demo.endpoint.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "brand_id")
    @JsonProperty("brandId")
    private Long brandId;

    @NotNull
    @Column(name = "start_date")
    @JsonProperty("startDate")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "end_date")
    @JsonProperty("endDate")
    private LocalDateTime endDate;

    @NotNull
    @Column(name = "price_list")
    @JsonProperty("priceList")
    private Long priceList;

    @NotNull
    @Column(name = "product_id")
    @JsonProperty("productId")
    private Long productId;

    @NotNull
    @Column(name = "priority")
    @JsonProperty("priority")
    private Integer priority;

    @NotNull
    @Column(name = "price")
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @Column(name = "curr")
    @JsonProperty("curr")
    private String curr;

    public Prices() {
    }

    public Prices(Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId, Integer priority, BigDecimal price, String curr) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    // Getters y Setters (o usar Lombok para generarlos automáticamente)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}