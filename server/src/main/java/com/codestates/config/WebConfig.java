package com.codestates.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 허용할 도메인
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // 허용할 메서드
                .exposedHeaders("Authorization", "Refresh","X-Total-Pages") // 허용된 도메인에 대해 노출시킬 헤더
                .allowedHeaders("*")
                .allowCredentials(false) // 쿠키 사용 여부
                .maxAge(3600); // 캐시 시간(초)
    }
}
