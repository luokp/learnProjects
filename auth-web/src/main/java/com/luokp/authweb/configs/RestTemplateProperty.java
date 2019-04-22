package com.luokp.authweb.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "aoc.remote")
public class RestTemplateProperty {
    private Integer maxTotalConnect = 200; //连接池的最大连接数
    private Integer maxConnectPerRoute = 200; //单个主机的最大连接数
    private Integer connectTimeout = 6000; //连接超时默认6s
    private Integer readTimeout = 60000; //读取超时默认60s
}
