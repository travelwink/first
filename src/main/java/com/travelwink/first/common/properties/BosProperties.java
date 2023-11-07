package com.travelwink.first.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "bos")
public class BosProperties {

    private String stsEndpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint;
    private String bucketName;
    private String envPath;
}
