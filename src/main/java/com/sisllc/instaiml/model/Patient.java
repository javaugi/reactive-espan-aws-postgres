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
@Table("patients")
public class Patient {

    @Id
    private String id;
    
    private String name;
    
    private String email;
    private String phone;
    private String address;

    @Column(name = "birth_date")
    private OffsetDateTime birthDate;

    @CreatedDate
    @Column(name = "created_date")
    private OffsetDateTime createdDate;   

    @LastModifiedDate
    @Column(name = "updated_date")
    private OffsetDateTime updatedDate;
}
