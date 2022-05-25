package org.bsuir.rankingapp.ranking.core.mapper;

import java.util.stream.Collectors;

import org.bsuir.rankingapp.ranking.api.model.ArticlePreviewResponse;
import org.bsuir.rankingapp.ranking.core.dal.domain.Article;
import org.bsuir.rankingapp.ranking.core.dal.domain.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

  @Mapping(target = "authors", source = ".", qualifiedByName = "mapAuthors")
  @Mapping(target = "venueAndYear", source = ".", qualifiedByName = "mapVenueAndYear")
  ArticlePreviewResponse toPreview(Article article);

  @Named("mapAuthors")
  default String mapAuthors(Article article) {
    var authors = article.getAuthors().stream().map(Author::getName)
        .collect(Collectors.toSet());
    return String.join(", ", authors);
  }

  @Named("mapVenueAndYear")
  default String mapVenueAndYear(Article article) {
    if (article.getVenue() == null || article.getVenue().isBlank()) {
      return String.format("%s", article.getYear());
    }
    return String.format("%s, %s", article.getVenue(), article.getYear());
  }
}
