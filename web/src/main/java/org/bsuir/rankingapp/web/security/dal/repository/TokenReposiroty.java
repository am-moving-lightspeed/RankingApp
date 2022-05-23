package org.bsuir.rankingapp.web.security.dal.repository;

import java.util.Optional;
import org.bsuir.rankingapp.web.security.dal.entity.BasicAuthToken;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenReposiroty extends Neo4jRepository<BasicAuthToken, String> {

  Optional<BasicAuthToken> getToken(String token);
}
