//package org.bsuir.rankingapp;
//
//import lombok.RequiredArgsConstructor;
//import org.neo4j.driver.AuthTokens;
//import org.neo4j.driver.Driver;
//import org.neo4j.driver.GraphDatabase;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.neo4j.config.AbstractNeo4jConfig;
//import org.springframework.data.neo4j.core.Neo4jClient;
//import org.springframework.data.neo4j.core.Neo4jTemplate;
//
//@Configuration
//@RequiredArgsConstructor
//public class DbConfiguration extends AbstractNeo4jConfig {
//
////  private final DbConfigurationProperties properties;
////
////  @Bean
////  @ConditionalOnMissingBean(Driver.class)
////  public Driver neo4jDriver() {
////    return GraphDatabase.driver(properties.getUri(),
////        AuthTokens.basic(properties.getAuthentication().getUsername(),
////            properties.getAuthentication().getPassword()));
////  }
//
////  @Bean
////  public Neo4jTemplate neo4jTemplate(Neo4jClient neo4jClient) {
////    return new Neo4jTemplate(neo4jClient)
////  }
////
////  @Override
////  public Driver driver() {
////    return Neo4jDataAutoConfiguration;
////  }
//}
