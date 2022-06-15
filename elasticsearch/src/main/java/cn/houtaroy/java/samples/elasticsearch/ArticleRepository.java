package cn.houtaroy.java.samples.elasticsearch;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Houtaroy
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
  @Highlight(fields = {
    @HighlightField(name = "title")
  })
  SearchHits<Article> findByTitle(String title);

  @Highlight(fields = {
    @HighlightField(name = "title"),
    @HighlightField(name = "author"),
    @HighlightField(name = "content"),
  })
  SearchPage<Article> findByTitleOrAuthorOrContent(String title, String author, String content, Pageable pageable);
}
