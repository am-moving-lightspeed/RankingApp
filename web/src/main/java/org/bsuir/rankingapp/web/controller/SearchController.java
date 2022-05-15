package org.bsuir.rankingapp.web.controller;

import static org.bsuir.rankingapp.web.constant.ControllerConstraints.SEARCH_PAGE;
import static org.bsuir.rankingapp.web.constant.ControllerConstraints.SEARCH_PARAM;
import static org.bsuir.rankingapp.web.constant.ControllerConstraints.SEARCH_RESULT_PAGE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(SEARCH_PAGE)
public class SearchController {

  @GetMapping
  public ResponseEntity<String> getSearchPage() {
    // TODO: add html resource.
    return new ResponseEntity<>("", HttpStatus.OK);
  }

  @GetMapping(params = {SEARCH_PARAM})
  public String delegateSearch(@RequestParam(SEARCH_PARAM) String query,
      RedirectAttributes redirectAttributes) {
    redirectAttributes.addAttribute(SEARCH_PARAM, query);
    return String.format("redirect:%s", SEARCH_RESULT_PAGE);
  }
}
