/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sisllc.instaiml.config;

import java.io.Serializable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(ProfileH2Config.H2_PROFILE)
@Configuration
public class ProfileH2Config implements Serializable {
    private static final long serialVersionUID = 35238717363L;
    public static final String H2_PROFILE = "h2";
    
}
