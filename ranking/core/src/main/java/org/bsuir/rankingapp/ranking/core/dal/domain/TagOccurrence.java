package org.bsuir.rankingapp.ranking.core.dal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagOccurrence {

  private Long endPosition;

  private String ne;

  private String pos;

  private Long startPosition;

  private String value;

  @Relationship(type = org.bsuir.rankingapp.ranking.core.config.Relationship.TAG_OCCURRENCE_TAG)
  private Tag tag;
}
