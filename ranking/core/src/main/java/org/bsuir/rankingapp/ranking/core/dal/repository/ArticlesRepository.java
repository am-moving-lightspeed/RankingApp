package org.bsuir.rankingapp.ranking.core.dal.repository;

import java.util.List;
import org.bsuir.rankingapp.ranking.core.dal.domain.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends Neo4jRepository<Article, String> {

  @Query("MATCH (art:Article)<-[rel:AUTHOR]-(aut:Author)"
      + " WITH art, collect(rel) AS rels, collect(aut) AS authors"
      + " RETURN art, rels,  authors"
      + " ORDER BY art.pageRank"
      + " LIMIT {0}")
  List<Article> getTopArticlesByPageRankLimitBy(Long limit, Pageable pageable);
  
}
