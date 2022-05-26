package org.bsuir.rankingapp.ranking.core.mapper;

import org.bsuir.rankingapp.ranking.api.model.AuthorResponse;
import org.bsuir.rankingapp.ranking.core.dal.domain.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

  AuthorResponse toResponse(Author author);
}
