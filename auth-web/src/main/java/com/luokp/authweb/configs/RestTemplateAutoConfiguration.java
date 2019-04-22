package com.luokp.authweb.configs;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
@ConditionalOnClass(value = {RestTemplate.class, HttpClient.class, RestTemplateProperty.class})
@EnableConfigurationProperties(RestTemplateProperty.class)
public class RestTemplateAutoConfiguration {
    @Autowired
    private RestTemplateProperty restTemplateProperty;

    //创建HTTP客户端工厂
    private ClientHttpRequestFactory createFactory() {
        if (restTemplateProperty.getMaxTotalConnect() <= 0) {
            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            factory.setConnectTimeout(restTemplateProperty.getConnectTimeout());
            factory.setReadTimeout(restTemplateProperty.getReadTimeout());
            return factory;
        }
        HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(restTemplateProperty.getMaxTotalConnect())
                .setMaxConnPerRoute(restTemplateProperty.getMaxConnectPerRoute()).setRetryHandler(new DefaultHttpRequestRetryHandler(3, true)).build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(
                httpClient);
        factory.setConnectTimeout(restTemplateProperty.getConnectTimeout());
        factory.setReadTimeout(restTemplateProperty.getReadTimeout());
        return factory;
    }

    //初始化RestTemplate,并加入spring的Bean工厂，由spring统一管理
    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(this.createFactory());
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();

        //重新设置StringHttpMessageConverter字符集为UTF-8，解决中文乱码问题
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (StringHttpMessageConverter.class == item.getClass()) {
                converterTarget = item;
                break;
            }
        }
        if (null != converterTarget) {
            converterList.remove(converterTarget);
        }
        converterList.add(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

}
