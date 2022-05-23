package org.bsuir.rankingapp;

import org.bsuir.rankingapp.ranking.core.dal.repository.ArticlesRepository;
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

    var repo = ctx.getBean(ArticlesRepository.class);
    System.out.println(repo.getTopArticlesByPageRankLimitBy(10L));
  }
}
