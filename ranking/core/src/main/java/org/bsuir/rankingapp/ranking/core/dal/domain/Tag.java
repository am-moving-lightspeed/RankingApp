package org.bsuir.rankingapp.ranking.core.dal.domain;

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
public class Tag {

  @Id
  private String id;

  private String language;

  private String lastTxId;

  private String ne;

  private String pos;

  private String value;
}
