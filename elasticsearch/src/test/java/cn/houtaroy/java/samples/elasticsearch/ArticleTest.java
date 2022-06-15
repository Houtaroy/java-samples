package cn.houtaroy.java.samples.elasticsearch;

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
public class ArticleTest {
  @Autowired
  private ArticleRepository articleRepository;

  @Test
  public void test() {
    Article one = Article.builder().id("1").title("狗的一生").author("狗").content("狗的一生").build();
    articleRepository.save(one);
    Assertions.assertEquals(articleRepository.findByTitle("狗").getTotalHits(), 1);
    Assertions.assertEquals(articleRepository.findByTitle("柯基").getTotalHits(), 1);
    Assertions.assertEquals(articleRepository.findByTitle("哈士奇").getTotalHits(), 0);
    articleRepository.deleteById("1");
  }
}
