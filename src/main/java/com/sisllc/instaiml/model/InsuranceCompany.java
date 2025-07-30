/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sisllc.instaiml.model;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table("insuranceCompanies")
public class InsuranceCompany {
    @Id 
    private String id;
    
    @Column(name = "company_code")
    private String companyCode;
    
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "state_licenses")
    private String stateLicenses;

    @Column(name = "financial_rating")
    private String financialRating;

    @Column(name = "contact_info")
    private String contactInfo;
    
    @Column(name = "market_share", precision = 10, scale = 2)
    private BigDecimal marketShare;

}
