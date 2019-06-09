package cn.mikulove;

import cn.mikulove.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2019/6/9.
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }

    //把idwork添加到容器中
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1,1);
    }
}
