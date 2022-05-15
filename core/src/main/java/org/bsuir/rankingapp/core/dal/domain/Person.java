package org.bsuir.rankingapp.core.dal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  @Id
  private String name;

  private Integer born;
}
