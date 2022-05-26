package org.bsuir.rankingapp.web.service;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.bsuir.rankingapp.ranking.api.contract.ArticleService;
import org.bsuir.rankingapp.ranking.api.contract.AuthorService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.ISpringTemplateEngine;

@Service
@RequiredArgsConstructor
public class HomeService {

  private final ArticleService articleService;
  private final AuthorService authorService;
  private final ISpringTemplateEngine springTemplateEngine;

  public String enrichArticleCardsTemplate() {
    var articles = articleService.getPopularArticles();
    var thymeleafContext = new Context(LocaleContextHolder.getLocale());
    thymeleafContext.setVariables(Map.of("articles", articles));
    return springTemplateEngine.process("templates/home/articles", thymeleafContext);
  }

  public String enrichAuthorCardsTemplate() {
    var authors = authorService.getPopularAuthors();
    var thymeleafContext = new Context(LocaleContextHolder.getLocale());
    thymeleafContext.setVariables(Map.of("articles", authors));
    return null;
  }
}
