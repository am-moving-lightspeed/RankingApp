package org.bsuir.rankingapp.web.controller;

import static org.bsuir.rankingapp.web.constant.ControllerConstraints.SEARCH_RESULT_PAGE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalController {

  @GetMapping(SEARCH_RESULT_PAGE)
  public void a() {

  }
}
