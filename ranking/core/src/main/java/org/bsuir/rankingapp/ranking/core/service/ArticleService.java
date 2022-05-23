package org.bsuir.rankingapp.ranking.core.service;

import lombok.RequiredArgsConstructor;
import org.bsuir.rankingapp.ranking.core.dal.repository.ArticlesRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

  private final ArticlesRepository repository;

  public void getTopArticles(Long amountToFetch, Pageable pageable) {
    var articles = repository.getTopArticlesByPageRankLimitBy(amountToFetch, pageable);
  }
}
