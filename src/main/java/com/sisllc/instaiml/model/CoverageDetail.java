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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table("coverageDetails")
public class CoverageDetail {
    @Id 
    private String id;
    
    @Column(name = "insurance_plan_id")
    private String insurancePlanId;
    
    @Column(name = "deductible_individual", precision = 10, scale = 2)
    private BigDecimal deductibleIndividual;

    @Column(name = "deductible_family", precision = 10, scale = 2)
    private BigDecimal deductibleFamily;

    @Column(name = "oop_max_individual", precision = 10, scale = 2)
    private BigDecimal oopMaxIndividual;

    @Column(name = "oop_max_family", precision = 10, scale = 2)
    private BigDecimal oopMaxFamily;

    @Column(name = "primary_care_copay", precision = 10, scale = 2)
    private BigDecimal primaryCareCopay;

    @Column(name = "specialist_copay", precision = 10, scale = 2)
    private BigDecimal specialistCopay;

    @Column(name = "er_copay", precision = 10, scale = 2)
    private BigDecimal erCopay;

    @Column(name = "prescription_tier1", precision = 10, scale = 2)
    private BigDecimal prescriptionTier1;

    @Column(name = "prescription_tier2", precision = 10, scale = 2)
    private BigDecimal prescriptionTier2;

    @Column(name = "prescription_tier3", precision = 10, scale = 2)
    private BigDecimal prescriptionTier3;
    
    @Column(name = "effective_date")
    private OffsetDateTime effectiveDate;

    @Column(name = "expiration_date")
    private OffsetDateTime expirationDate;
}
