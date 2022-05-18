package com.soundSystem;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@Import(CDConfig.class)
//@ImportResource("classpath:cd-config.xml")
//@ComponentScan
//@ComponentScan(basePackages = "com.soundSystem")
//@ComponentScan(basePackageClasses = ScanTag.class)
public class CDPlayerConfig {

    @Bean
    public CompactDisc disc(){
        return new CDPlayer();
    }

//    @Bean
//    public CDPlayer cdPlayer(CompactDisc compactDisc){
//        return new CDPlayer(compactDisc);
//    }
}
