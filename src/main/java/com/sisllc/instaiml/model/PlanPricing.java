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
@Table("planPricings")
public class PlanPricing {
    @Id 
    private String id;
    
    @Column(name = "insurance_plan_id")
    private String insurancePlanId;
        
    @Column(name = "pricing_type")
    private String pricingType; //(e.g. premium, deductible),
    
    @Column(name = "base_premium", precision = 10, scale = 2)
    private BigDecimal basePremium;
    
    @Column(name = "tobacco_surcharge", precision = 10, scale = 2)
    private BigDecimal tobaccoSurcharge;
    
    @Column(name = "family_coverage_adjustment", precision = 10, scale = 2)
    private BigDecimal familyCoverageAdjustment;
    
    @Column(name = "misc_adjustment", precision = 10, scale = 2)
    private BigDecimal miscAdjustment;
    
    @Column(name = "age_bracket")
    private String ageBracket;

    @Column(name = "coverage_level")
    private String coverageLevel;
    
    @Column(name = "effective_date")
    private OffsetDateTime effectiveDate;

    @Column(name = "expiration_date")
    private OffsetDateTime expirationDate;

}
