package org.bsuir.rankingapp.ranking.api.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class AuthorResponse {

  private String name;

  private BigDecimal personalRank;
}
