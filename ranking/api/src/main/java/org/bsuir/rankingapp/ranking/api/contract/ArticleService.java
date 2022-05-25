package org.bsuir.rankingapp.ranking.api.contract;

import org.bsuir.rankingapp.ranking.api.model.ArticlePreviewResponse;
import java.util.List;

public interface ArticleService {

  List<ArticlePreviewResponse> getPopularArticles();
}
