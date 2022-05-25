package org.bsuir.rankingapp.ranking.api.model;

import lombok.Data;

@Data
public class ArticlePreviewResponse {

  private String title;

  private String about;

  private String authors;

  private String venueAndYear;
}
