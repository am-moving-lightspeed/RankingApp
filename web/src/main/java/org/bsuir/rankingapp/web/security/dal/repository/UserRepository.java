package org.bsuir.rankingapp.web.security.dal.repository;

import java.util.Optional;
import org.bsuir.rankingapp.web.security.dal.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends Neo4jRepository<User, String> {

  Optional<User> findByUsernameAndPassword(String username, String password);
}
