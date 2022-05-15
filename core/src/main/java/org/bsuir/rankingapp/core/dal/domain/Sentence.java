package org.bsuir.rankingapp.core.dal.domain;

import static org.bsuir.rankingapp.core.config.Relationship.HAS_TAG;
import static org.bsuir.rankingapp.core.config.Relationship.NEXT_SENTENCE;
import static org.bsuir.rankingapp.core.config.Relationship.SENTENCE_TAG_OCCURRENCE;

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
public class Sentence {

  @Id
  private String id;

  private String hash;

  @Property(name = "sentenceNumber")
  private Long number;

  private String text;

  @Relationship(type = NEXT_SENTENCE)
  private String nextSentence;

  @Relationship(type = SENTENCE_TAG_OCCURRENCE)
  private Set<TagOccurrence> tagOccurrences = new HashSet<>();

  @Relationship(type = HAS_TAG)
  private Set<Tag> tags = new HashSet<>();
}
