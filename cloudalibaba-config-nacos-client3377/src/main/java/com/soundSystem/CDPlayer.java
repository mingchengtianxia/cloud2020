package com.soundSystem;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CDPlayer implements CompactDisc{

    static String author = "test";



    @Override
    public void playSound() {
        System.out.println("CD play"+author);
    }
}
