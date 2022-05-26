package org.bsuir.rankingapp.ranking.api.contract;

import java.util.List;
import org.bsuir.rankingapp.ranking.api.model.AuthorResponse;

public interface AuthorService {

  List<AuthorResponse> getPopularAuthors();
}
