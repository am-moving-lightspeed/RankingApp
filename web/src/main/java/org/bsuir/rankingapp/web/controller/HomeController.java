package org.bsuir.rankingapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.bsuir.rankingapp.web.constant.TemplateName;
import org.bsuir.rankingapp.web.service.HomeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

  private final HomeService homeService;

  @GetMapping
  public String redirectToIndex() {
    return "redirect:/g";
  }

  @GetMapping("g")
  public String getIndex() {
    return TemplateName.PG_INDEX;
  }

  @ResponseBody
  @GetMapping("g:get-articles")
  public ResponseEntity<String> getArticles() {
    var body = homeService.enrichArticleCardsTemplate();
    var headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_HTML);
    return new ResponseEntity<>(body, headers, HttpStatus.OK);
  }

  @ResponseBody
  @GetMapping("g:get-authors")
  public ResponseEntity<String> getAuthors() {
    return null;
  }
}
