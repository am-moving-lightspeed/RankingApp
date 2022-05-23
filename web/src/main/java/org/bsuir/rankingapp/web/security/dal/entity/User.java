package org.bsuir.rankingapp.web.security.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  private String index;

  private String username;

  private String password;

  @Relationship(type = "HAS_AUTHORITY")
  private List<Authority> authorities = new ArrayList<>();
}
