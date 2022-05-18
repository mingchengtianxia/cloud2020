package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //支持nacos的动态刷新
public class ConfigCenterController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }


    public static void main(String[] args) {
        new ConfigCenterController().restart();
    }

    private void restart(){
        String name = "threadController";
        Thread thread = new Thread(this::run, name);
        thread.setUncaughtExceptionHandler((t,e)->{
            System.out.println("error"+e);
            restart();
        });
        System.out.println("main");
        thread.start();
        System.out.println("main end");
    }

    final void run(){
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
