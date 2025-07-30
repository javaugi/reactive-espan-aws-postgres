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
@Table("claimsData")
public class ClaimsData {
    @Id 
    private String id;
    
    @Column(name = "insurance_plan_id")
    private String insurancePlanId;
    
    @Column(name = "member_id")
    private String memberId;    
    
    @Column(name = "provider_id")
    private String providerId;    
    
    @Column(name = "billed_amount", precision = 10, scale = 2)
    private BigDecimal billedAmount;
    
    @Column(name = "allowed_amount", precision = 10, scale = 2)
    private BigDecimal allowedAmount;
    
    @Column(name = "paid_amount", precision = 10, scale = 2)
    private BigDecimal paidAmount;
    
    @Column(name = "diagnosis_codes")
    private String diagnosisCodes;
    
    @Column(name = "procedure_codes")
    private String procedureCodes;
    
    @Column(name = "claim_status")
    private String claimStatus;
    
    @Column(name = "service_date")
    private OffsetDateTime serviceDate;
    
    @Column(name = "claim_date")
    private OffsetDateTime claimDate;
    
    @CreatedDate
    @Column(name = "created_date")
    private OffsetDateTime createdDate;   

    @LastModifiedDate
    @Column(name = "updated_date")
    private OffsetDateTime updatedDate;
}
