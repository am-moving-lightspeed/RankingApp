package org.bsuir.rankingapp.web.security.dal.repository;

import java.util.Collection;
import java.util.List;
import org.bsuir.rankingapp.web.security.dal.entity.Authority;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends Neo4jRepository<Authority, String> {

  @Query("MATCH (aut:Authority) WHERE aut.authority IN ({0}) RETURN aut")
  List<Authority> getAuthorities(Collection<String> authorities);
}
