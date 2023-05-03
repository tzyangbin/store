package com.tz.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * @author tzyan
 * @author tzyan
 */
//配置类
//@Configuration
@SpringBootApplication
//mapper scan注解指定当前项目中接口路径的位置,在项目启动自动加载
@MapperScan("com.tz.store.mapper")
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
//创建一个工厂对象MultipartConfigElement
//    @Bean
//    public MultipartConfigElement getMultipartConfigElement(){
//        //创建一个工厂对象
//        MultipartConfigFactory factory= new MultipartConfigFactory();
//        factory.setMaxFileSize(DataSize.of(1, DataUnit.MEGABYTES));
//        factory.setMaxRequestSize(DataSize.of(2,DataUnit.MEGABYTES));
//        return factory.createMultipartConfig();
//    }

}
