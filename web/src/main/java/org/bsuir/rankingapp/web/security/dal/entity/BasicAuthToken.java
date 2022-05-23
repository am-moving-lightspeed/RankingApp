package org.bsuir.rankingapp.web.security.dal.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasicAuthToken {

  @Id
  private String token;

  @Relationship(type = "ISSUED_WITH_AUTHORITY")
  private List<Authority> authorities;
}
