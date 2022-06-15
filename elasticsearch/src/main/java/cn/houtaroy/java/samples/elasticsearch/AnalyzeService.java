package cn.houtaroy.java.samples.elasticsearch;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.AnalyzeRequest;
import org.elasticsearch.client.indices.AnalyzeResponse;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Houtaroy
 */
@Component
@RequiredArgsConstructor
public class AnalyzeService {
  public static final String DEFAULT_CHINESE_ANALYZER = "ik_smart";
  private final ElasticsearchRestTemplate elasticsearchRestTemplate;

  /**
   * 分词
   *
   * @param text 待分词文本
   * @return 分词结果
   */
  public AnalyzeResponse global(String text) {
    return global(DEFAULT_CHINESE_ANALYZER, text);
  }

  /**
   * 全局分词
   *
   * @param analyzer 分词器
   * @param text     待分词文本
   * @return 分词结果
   */
  public AnalyzeResponse global(String analyzer, String text) {
    return elasticsearchRestTemplate.execute(client -> {
      AnalyzeRequest request = AnalyzeRequest.withGlobalAnalyzer(analyzer, text);
      return client.indices().analyze(request, RequestOptions.DEFAULT);
    });
  }

  /**
   * 索引分词
   *
   * @param text 待分词文本
   * @return 分词结果
   */
  public AnalyzeResponse index(String indexName, String text) {
    return index(indexName, DEFAULT_CHINESE_ANALYZER, text);
  }

  /**
   * 索引分词
   *
   * @param indexName 索引名称
   * @param analyzer  分词器
   * @param text      待分词文本
   * @return 分词结果
   */
  public AnalyzeResponse index(String indexName, String analyzer, String text) {
    return elasticsearchRestTemplate.execute(client -> {
      AnalyzeRequest request = AnalyzeRequest.withIndexAnalyzer(indexName, analyzer, text);
      return client.indices().analyze(request, RequestOptions.DEFAULT);
    });
  }
}
