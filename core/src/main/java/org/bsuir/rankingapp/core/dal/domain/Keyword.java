package org.bsuir.rankingapp.core.dal.domain;

import static org.bsuir.rankingapp.core.config.Relationship.DESCRIBES;

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
public class Keyword {

  @Id
  private String id;

  @Property(name = "keywordsList")
  private Set<String> keywords;

  private Long numTerms;

  private String originalTagId;

  private String originalTagValue;

  private String value;

  @Relationship(type = DESCRIBES)
  private Set<AnnotatedText> annotatedTexts = new HashSet<>();
}
