package com.soundSystem;

import com.desserteater.DessertConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={CDPlayerConfig.class, DessertConfig.class})
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private CDPlayer player;

    @Test
    public void testPlay(){
        Assert.assertNotNull(cd);
    }

    @Test
    public void testCDPlayer(){
        player.playSound();
    }
}
