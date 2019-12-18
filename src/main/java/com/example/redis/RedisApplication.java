package com.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author raintrees
 * @date 2019/12/17 17:27
 */
@SpringBootApplication
//@EnableCaching  //开启缓存功能
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class,args);
    }
}
