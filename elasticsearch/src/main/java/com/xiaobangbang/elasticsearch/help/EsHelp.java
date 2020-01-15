package com.xiaobangbang.elasticsearch.help;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;

/**
 * es方法集合
 * @author peyazhuo
 * @date 2020/1/13
 */
@Configuration
public class EsHelp {



    @Bean
    public RestClient getRestClient(){
        //设置httpHost
        HttpHost httpHost = new HttpHost("192.168.10.18", 9200, "http");
        //获取RestClientBuilder
        RestClientBuilder restClientBuilder = RestClient.builder(httpHost);
        //连接时间   参照 AbstractHttpTransport
        restClientBuilder.setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.
                //10000
                setConnectTimeout(60000)
                //10000
                .setConnectionRequestTimeout(60000)
                //600000
                .setSocketTimeout(60000))
                // 默认值  DEFAULT_MAX_RETRY_TIMEOUT_MILLIS  30000
                .setMaxRetryTimeoutMillis(60000)
        ;
        //设置连接用户名密码
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "ZVVVWMUxycFHLXGvJrV8"));
        restClientBuilder.setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                //是整个连接池的大小   AbstractHttpTransport  1000 （默认30，暂时设置成数据库连接池一致50）
                .setMaxConnTotal(10000)
                //是单个路由连接的最大数  AbstractHttpTransport  500
//                    .setMaxConnPerRoute(500)
                .setDefaultCredentialsProvider(credentialsProvider)
                .setDefaultIOReactorConfig(
                        IOReactorConfig.custom()
                                .build()));
        return restClientBuilder.build();
    }
    @Bean
    public RestHighLevelClient getRestHighLevelClient(){
        return new RestHighLevelClient(getRestClient());
    }

    public void searchForPage() throws IOException {
        //创建searchRequest(请求头),设置index和types
        SearchRequest request = new SearchRequest("idx_saas_product");
        request.types("saas_product");

        //SearchSourceBuilder(设置常见查询（第几页，排序，超时），各种查询请求体)
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(1);
        builder.size(10);
        builder.timeout(new TimeValue(10000));
        //设置查询builder
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        //查询含嘿或哈
        boolQueryBuilder.filter(QueryBuilders.matchQuery("data.text_1","嘿哈"));
        boolQueryBuilder.should(QueryBuilders.termQuery("data.text_1.keyword","嘿哈"));
        boolQueryBuilder.should(QueryBuilders.termQuery("data.text_1.keyword","哈哈"));
        builder.query(boolQueryBuilder);
        request.source(builder);
        //查询
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println("bulider:  "+builder.toString());
        System.out.println(request);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(getRestClient());
        SearchResponse response = restHighLevelClient.search(request);
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println(response.toString());
    }

    //更新文档
    public void updateEs(){
        UpdateRequest request = new UpdateRequest("idx_saas_product", "saas_product", "1_37");
        HashMap<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("data.text_1","嘿哈嘿哈");
        try {
            UpdateResponse updateResponse = getRestHighLevelClient().update(request);
            System.out.println("=====================");
            System.out.println("=====================");
            System.out.println(updateResponse);
        } catch (IOException e) {
            System.out.println("修改失败");
        }
    }




}
