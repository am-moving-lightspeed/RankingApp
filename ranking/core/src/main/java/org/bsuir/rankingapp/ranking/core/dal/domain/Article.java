package org.bsuir.rankingapp.ranking.core.dal.domain;

import static org.bsuir.rankingapp.ranking.core.config.Relationship.AUTHOR;
import static org.bsuir.rankingapp.ranking.core.config.Relationship.HAS_ANNOTATED_TEXT;
import static org.bsuir.rankingapp.ranking.core.config.Relationship.REFERENCES;
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
public class Article {

  @Id
  private String index;

  private String title;

  @Property(name = "abstract")
  private String about;

  private String venue;

  private Integer year;

  private Double pageRank;

  @Relationship(type = AUTHOR, direction = INCOMING)
  private Set<Author> authors = new HashSet<>();

  @Relationship(type = REFERENCES)
  private Set<Article> referencesTo = new HashSet<>();

  @Relationship(type = REFERENCES, direction = INCOMING)
  private Set<Article> referencedBy = new HashSet<>();

  @Relationship(type = HAS_ANNOTATED_TEXT)
  private AnnotatedText annotatedText;
}
