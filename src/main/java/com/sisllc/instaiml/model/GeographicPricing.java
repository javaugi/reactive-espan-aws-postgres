/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sisllc.instaiml.model;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

    @Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table("geographicPricings")
public class GeographicPricing {
    @Id 
    private String id;
    
    @Column(name = "insurance_plan_id")
    private String insurancePlanId;
        
    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "state_abbr")
    private String stateAbbr;
    
    @Column(name = "adjustment_factor", precision = 10, scale = 2)
    private BigDecimal adjustmentFactor;
    
    @Column(name = "rating_area")
    private int ratingArea;

    @Column(name = "effective_date")
    private OffsetDateTime effectiveDate;

    @Column(name = "expiration_date")
    private OffsetDateTime expirationDate;

}
