# Elasticsearch

- 分词查询: `AnalyzeService`
- 动态同义词配置: `resource\elasticsearch\settings\default.json`

## 分词

分词支持全局分词和索引库分词

## 同义词

动态同义词插件请参考: [elasticsearch-analysis-dynamic-synonym](https://github.com/Houtaroy/elasticsearch-analysis-dynamic-synonym)

同义词高亮查询时, 同义词自身会高亮, 例如:

柯基, 狗

使用柯基进行查询时, 结果中的`狗`会高亮