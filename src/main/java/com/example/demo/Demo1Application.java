package com.example.demo;

import com.example.demo.config.KeycloakServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@ConfigurationPropertiesScan
@SpringBootApplication
public class Demo1Application {
  private static final Logger LOG = LoggerFactory.getLogger(Demo1Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Demo1Application.class, args);
  }

  @Bean
  ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(
      ServerProperties serverProperties, KeycloakServerProperties keycloakServerProperties) {
    return (evt) -> {
      Integer port = serverProperties.getPort();
      String keycloakContextPath = keycloakServerProperties.getContextPath();
      LOG.info("Embedded Keycloak started: http://localhost:{}{} to use keycloak",
               port, keycloakContextPath);
    };
  }

}
