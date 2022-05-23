package org.bsuir.rankingapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.bsuir.rankingapp.web.constant.TemplateName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.ITemplateEngine;

@Controller
@RequestMapping("/g")
@RequiredArgsConstructor
public class MainController {

  private final ITemplateEngine templateEngine;

//  @GetMapping(SEARCH_RESULT_PAGE)
//  public void a() {
//
//  }

  @GetMapping
  public String getIndex() {
    return TemplateName.PG_INDEX;
  }

  @GetMapping(":get-articles")
  public void getArticles() {

  }
}
