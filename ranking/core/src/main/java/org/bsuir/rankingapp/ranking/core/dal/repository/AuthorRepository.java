package org.bsuir.rankingapp.ranking.core.dal.repository;

import java.util.List;
import org.bsuir.rankingapp.ranking.core.dal.domain.Author;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends Neo4jRepository<Author, String> {

  @Query("MATCH (a:Author) RETURN a ORDER BY a.personalRank DESC LIMIT 10")
  List<Author> getTopAuthorsByPersonalRankLimitBy(Long limit);
}
