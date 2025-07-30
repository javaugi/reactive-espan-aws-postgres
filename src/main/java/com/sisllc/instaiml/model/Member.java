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
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table("members")
public class Member {
    @Id 
    private String id;
    
    @Column(name = "insurance_plan_id")
    private String insurancePlanId;
    
    private String name;
    private String gender;
    private String address;
    
    @Column(name = "tobacco_user")
    private boolean tobaccoUser;
    
    @Column(name = "birth_date")
    private OffsetDateTime birthDate;

    @Column(name = "enrollment_date")
    private OffsetDateTime enrollmentDate;

    @Column(name = "termination_date")
    private OffsetDateTime terminationDate;

}
