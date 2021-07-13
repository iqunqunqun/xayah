package com.ivan.xayah;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p></p>
 *
 * @author ivan
 * @className SystemApplication
 * @since 2021/3/7 15:27
 */

@EnableFeignClients
@SpringBootApplication
@MapperScan("com.ivan.xayah.mapper")
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
