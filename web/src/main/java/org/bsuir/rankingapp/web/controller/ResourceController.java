package org.bsuir.rankingapp.web.controller;

import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.bsuir.rankingapp.web.constant.ResourceConstraints;
import org.bsuir.rankingapp.web.service.ResourceService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceController {

  private final ResourceService resourceService;

  @GetMapping(path = "/stylesheet/{resourceName}", produces = ResourceConstraints.TEXT_CSS)
  public HttpEntity<Resource> getStylesheet(@PathVariable String resourceName) {
    var mediaType = new MediaType(MediaType.parseMediaType(ResourceConstraints.TEXT_CSS),
        StandardCharsets.UTF_8);
    var headers = new HttpHeaders();
    headers.setContentType(mediaType);
    return new HttpEntity<>(resourceService.getStylesheetResource(resourceName), headers);
  }

  @GetMapping(path = "/js/{resourceName}", produces = ResourceConstraints.APPLICATION_JAVASCRIPT)
  public HttpEntity<Resource> getScript(@PathVariable String resourceName) {
    var mediaType = new MediaType(
        MediaType.parseMediaType(ResourceConstraints.APPLICATION_JAVASCRIPT),
        StandardCharsets.UTF_8);
    var headers = new HttpHeaders();
    headers.setContentType(mediaType);
    return new HttpEntity<>(resourceService.getJavaScriptResource(resourceName), headers);
  }
}
