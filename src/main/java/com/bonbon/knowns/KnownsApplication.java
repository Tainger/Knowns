package com.bonbon.knowns;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/9/7 8:59
 */

@SpringBootApplication
@MapperScan("com.bonbon.knowns.mapper")
public class KnownsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnownsApplication.class,args);
    }
}
