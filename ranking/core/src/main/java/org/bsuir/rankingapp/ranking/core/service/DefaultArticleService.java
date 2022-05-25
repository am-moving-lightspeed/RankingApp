package org.bsuir.rankingapp.ranking.core.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.bsuir.rankingapp.ranking.api.contract.ArticleService;
import org.bsuir.rankingapp.ranking.api.model.ArticlePreviewResponse;
import org.bsuir.rankingapp.ranking.core.dal.repository.ArticlesRepository;
import org.bsuir.rankingapp.ranking.core.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultArticleService implements ArticleService {

  private final ArticleMapper articleMapper;
  private final ArticlesRepository repository;

  @Override
  public List<ArticlePreviewResponse> getPopularArticles() {
    return repository.getTopArticlesByPageRankLimitBy(10L).stream()
        .map(articleMapper::toPreview).collect(Collectors.toList());
  }
}
