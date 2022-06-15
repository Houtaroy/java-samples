package cn.houtaroy.java.samples.elasticsearch;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;

/**
 * @author Houtaroy
 */
@Data
@Document(indexName = "articles")
@NoArgsConstructor
@Setting(settingPath = "elasticsearch/settings/default.json")
@SuperBuilder(toBuilder = true)
public class Article {
  @Id
  private String id;
  @Field
  private String title;
  @Field
  private String author;
  @Field
  private String content;
  @Field
  private Date createTime;
}
