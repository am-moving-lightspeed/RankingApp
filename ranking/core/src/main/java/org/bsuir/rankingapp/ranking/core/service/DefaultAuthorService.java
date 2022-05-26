package org.bsuir.rankingapp.ranking.core.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.bsuir.rankingapp.ranking.api.contract.AuthorService;
import org.bsuir.rankingapp.ranking.api.model.AuthorResponse;
import org.bsuir.rankingapp.ranking.core.dal.repository.AuthorRepository;
import org.bsuir.rankingapp.ranking.core.mapper.AuthorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultAuthorService implements AuthorService {

  private final AuthorMapper authorMapper;
  private final AuthorRepository authorRepository;

  public List<AuthorResponse> getPopularAuthors() {
    var authors = authorRepository.getTopAuthorsByPersonalRankLimitBy(10L);
    return authors.stream().map(authorMapper::toResponse).collect(Collectors.toList());
  }
}
