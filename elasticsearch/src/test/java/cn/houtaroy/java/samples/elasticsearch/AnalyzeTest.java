package cn.houtaroy.java.samples.elasticsearch;

import org.elasticsearch.client.indices.AnalyzeResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Houtaroy
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ElasticsearchApplication.class)
public class AnalyzeTest {
  @Autowired
  private AnalyzeService analyzeService;

  @Test
  public void global() {
    AnalyzeResponse response = analyzeService.global("我是中国人");
    Assertions.assertEquals(response.getTokens().size(), 3);
    Assertions.assertEquals(response.getTokens().get(0).getTerm(), "我");
  }

  @Test
  public void index() {
    AnalyzeResponse response = analyzeService.index("articles", "我是中国人");
    Assertions.assertEquals(response.getTokens().size(), 3);
    Assertions.assertEquals(response.getTokens().get(0).getTerm(), "我");
  }
}
