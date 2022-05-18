package com.desserteater;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("cold")
@Cold
public class Cake implements Dessert{
}
