/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sisllc.instaiml;

import com.sisllc.instaiml.config.DatabaseProperties;
import com.sisllc.instaiml.config.DatabaseProperties.ProfileSetting;
import org.h2.tools.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class H2TcpWebServers {
    private static final String SERVER_STATUS = "\n The H2 TCP Server started at port 9092: status %s URL=%s \n The H2 Web Server started at port 9093: status %s URL=%s ";
    private static String h2RunningStatus = "";
    
    private Server tcpServer;
    private Server webServer;
    
    @Autowired
    protected DatabaseProperties dbProps;

    @EventListener(ContextRefreshedEvent.class)
    public void start() throws Exception {
        if (dbProps.getProfileSetting() == ProfileSetting.H2) {
            this.tcpServer = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", dbProps.getH2TcpServerPort(), "-ifNotExists").start();
            this.webServer = Server.createWebServer("-webPort", dbProps.getH2WebServerPort(), "-tcpAllowOthers").start();        
            h2RunningStatus = String.format(SERVER_STATUS, this.tcpServer.getStatus(), this.tcpServer.getURL(), this.webServer.getStatus(), this.webServer.getURL());
        } else {
            h2RunningStatus = "Running Database " + dbProps.getDatabaseUsed();
        }
        
        log.info(h2RunningStatus);
    }

    @EventListener(ContextClosedEvent.class)
    public void stop() {
        if (tcpServer != null) {
            tcpServer.stop();
        }
        if (webServer != null) {
            webServer.stop();
        }
    }

    public static String getRunningStatus() {
        return h2RunningStatus;
    }

    @Override
    public String toString() {
        return h2RunningStatus;
    }
           
}


/*
Key Configuration Details:
    @EnableWebFluxSecurity: This annotation is essential for enabling Spring Security's reactive support.
    ServerHttpSecurity: This is the reactive equivalent of HttpSecurity.
    csrf(ServerHttpSecurity.CsrfSpec::disable): This disables CSRF protection. The H2 console doesn't use CSRF tokens, so you must disable this for its paths (or for the whole application if you're comfortable with that for a development environment).
    authorizeExchange(...): This is the reactive way to configure authorization rules. You use pathMatchers() to specify the URL patterns and then apply a rule like permitAll().
    pathMatchers("/h2-console/**").permitAll(): This is the crucial part that allows unauthenticated access to the H2 console's paths.

How to Use it:
    Start your Spring Boot WebFlux application.
    The H2 console will start on its own, separate port (e.g., 8082).
    Your main WebFlux application will be running on its configured port (e.g., 8080).
    Navigate to http://localhost:9093/ in your browser to access the H2 console.
    DBeaver url: jdbc:h2:tcp://localhost:9092/~/testdb


This approach bypasses the limitations of the servlet-based H2 console and allows it to coexist gracefully with your reactive WebFlux application. It's the most robust and recommended solution.
*/