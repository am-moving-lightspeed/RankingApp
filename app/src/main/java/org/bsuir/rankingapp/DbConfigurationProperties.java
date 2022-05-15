package org.bsuir.rankingapp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("spring.neo4j")
@Component
@Getter
@Setter
public class DbConfigurationProperties {

  private String uri;
  private Authentication authentication;

  @Getter
  @Setter
  public static class Authentication {

    private String username;
    private String password;
  }
}
