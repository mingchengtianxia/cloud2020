package com.desserteater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DessertConfig {

    private Dessert dessert;

    @Autowired
//    @Qualifier("iceCream")
//    @Qualifier("cold")
    @Cold
    public void setDessert(Dessert dessert){
        this.dessert = dessert;
    }
}
