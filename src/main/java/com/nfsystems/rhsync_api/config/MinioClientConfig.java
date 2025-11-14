package com.nfsystems.rhsync_api.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioClientConfig {

    @Value("${minio.url}")
    private String endPointMinio;

    @Value("${minio.config.access-key}")
    private String userMinio;

    @Value("${minio.config.secret-key}")
    private String passwordMinio;

    @Bean
    public MinioClient minioClient(){
        return MinioClient.builder()
                .endpoint(endPointMinio)
                .credentials(userMinio, passwordMinio)
                .build();
    }
}
