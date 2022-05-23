package org.bsuir.rankingapp.ranking.core.dal.domain;

import static org.bsuir.rankingapp.ranking.core.config.Relationship.CONTAINS_SENTENCE;
import static org.bsuir.rankingapp.ranking.core.config.Relationship.FIRST_SENTENCE;
import static org.bsuir.rankingapp.ranking.core.config.Relationship.KEYWORD;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;

import java.util.HashSet;
import java.util.Set;
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
public class AnnotatedText {

  @Id
  private Long id;

  private Long numTerms;

  @Relationship(type = KEYWORD, direction = INCOMING)
  private Set<Keyword> keywords = new HashSet<>();

  @Relationship(type = FIRST_SENTENCE)
  private Sentence firstSentence;

  @Relationship(type = CONTAINS_SENTENCE)
  private Set<Sentence> containsSentences = new HashSet<>();
}
