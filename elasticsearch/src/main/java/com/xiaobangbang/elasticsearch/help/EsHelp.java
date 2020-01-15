package com.xiaobangbang.elasticsearch.help;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
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
    private String esIp = "192.168.10.18";

    private int prot = 9200;

    private String type = "http";

    private String username = "elastic";
    private String password = "ZVVVWMUxycFHLXGvJrV8";


    @Bean
    public RestClient getRestClient(){
        //设置httpHost
        HttpHost httpHost = new HttpHost(esIp, prot, type);
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
                new UsernamePasswordCredentials(username, password));
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

    public void searchForPage() {
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
        SearchResponse response = null;
        try {
            response = restHighLevelClient.search(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println(response.toString());
    }

    //更新文档
    public void updateEs(){
        UpdateRequest request = new UpdateRequest("idx_saas_product", "saas_product", "1_37");
        HashMap<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("data.text_1","嘿哈嘿哈");
        request.doc(jsonMap);
        try {
            UpdateResponse updateResponse = getRestHighLevelClient().update(request);
            System.out.println("=====================");
            System.out.println("=====================");
            System.out.println(request.toString());
            System.out.println(updateResponse);
            //UpdateResponse[index=idx_saas_product,type=saas_product,id=1_37,version=2,result=updated,shards=ShardInfo{total=2, successful=2, failures=[]}]
        } catch (IOException e) {
            System.out.println("修改失败");
        }
    }
    //获取单个文档
    public void getOneDoc(){
        GetRequest getRequest = new GetRequest("idx_saas_product", "saas_product", "1_37");
        getRequest.routing("1_37");
        try {
            GetResponse response = getRestHighLevelClient().get(getRequest);
            System.out.println("=====================");
            System.out.println("=====================");
            System.out.println(getRequest.toString());
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
