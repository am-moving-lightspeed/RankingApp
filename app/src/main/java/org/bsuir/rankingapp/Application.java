package org.bsuir.rankingapp;

import org.bsuir.rankingapp.core.dal.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EntityScan
@EnableNeo4jRepositories
public class Application {

  public static void main(String[] args) {
    var ctx = SpringApplication.run(Application.class, args);

    var repo = ctx.getBean(MovieRepository.class);
    System.out.println(repo.findByTitle("Hoffa"));
  }
}
