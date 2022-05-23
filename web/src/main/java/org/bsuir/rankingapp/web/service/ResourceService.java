package org.bsuir.rankingapp.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:properties/resource-locations.properties")
@RequiredArgsConstructor
public class ResourceService {

  private final ResourceLoader resourceLoader;

  @Value("${stylesheets.root}")
  private String stylesheetsRoot;

  public Resource getStylesheetResource(String resourceName) {
    var fullName = String.format("%s/%s", stylesheetsRoot, resourceName);
    return resourceLoader.getResource(fullName);
  }
}
