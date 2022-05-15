package org.bsuir.rankingapp.core.dal.domain;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

  @Id
  private String title;

  @Property("tagline")
  private String description;

  @Relationship(type = "ACTED_IN", direction = INCOMING)
  private Set<Person> actors = new HashSet<>();

  @Relationship(type = "DIRECTED", direction = INCOMING)
  private Set<Person> directors = new HashSet<>();
}
