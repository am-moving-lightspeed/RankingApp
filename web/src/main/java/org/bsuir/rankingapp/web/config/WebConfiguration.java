package org.bsuir.rankingapp.web.config;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration {

  @Primary
  @Bean("TemplateResolver")
  public ITemplateResolver templateResolver(ApplicationContext applicationContext) {
    var templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setApplicationContext(applicationContext);
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setPrefix("classpath:/web/");
    templateResolver.setSuffix(".html");
    templateResolver.setCacheable(false);
    return templateResolver;
  }

  @Bean
  public ViewResolver htmlViewResolver(ITemplateResolver templateResolver) {
    var resolver = new ThymeleafViewResolver();
    resolver.setTemplateEngine(templateEngine(templateResolver));
    resolver.setContentType("text/html");
    resolver.setCharacterEncoding("UTF-8");
    resolver.setViewNames(ArrayUtils.toArray("*.html"));
    return resolver;
  }

  @Bean("TemplateEngine")
  public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
    var templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver);
    return templateEngine;
  }
}
