/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sisllc.instaiml.model;

import jakarta.persistence.Column;
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
@Table("insurancePlans")
public class InsurancePlan {
    @Id 
    private String id;
        
    @Column(name = "insurance_company_id")
    private String insuranceCompanyId;
        
    @Column(name = "plan_name")
    private String planName;

    @Column(name = "plan_type")
    private String planType;

    @Column(name = "network_type")
    private String networkType;

    @Column(name = "tier_level")
    private String tierLevel;

    private boolean active;

    @Column(name = "effective_date")
    private OffsetDateTime effectiveDate;

    @Column(name = "expiration_date")
    private OffsetDateTime expirationDate;

    @CreatedDate
    @Column(name = "created_date")
    private OffsetDateTime createdDate;   

    @LastModifiedDate
    @Column(name = "updated_date")
    private OffsetDateTime updatedDate;
}
