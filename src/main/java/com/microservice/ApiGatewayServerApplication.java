package com.microservice;

import com.microservice.filter.AuthHeaderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApiGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServerApplication.class, args);
    }

    @Bean
    // creating a sampler called
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    //    @Bean
//    AuthHeaderFilter authHeaderFilter() {
//        return new AuthHeaderFilter();
//    }
}
