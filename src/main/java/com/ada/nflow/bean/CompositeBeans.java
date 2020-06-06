package com.ada.nflow.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompositeBeans {

    @Autowired
    AnotherBean anotherBean;

    public CompositeBeans() {
        System.out.println("CompositeBeans constructor.....");
    }

    @Bean
    public SimpleBeans simpleBean1() {
        System.out.println("simpleBean1 creation .....");
        return new SimpleBeans();
    }

    @Bean
    public SimpleBeans simpleBean2() {
        System.out.println("simpleBean2 creation.....");
        return new SimpleBeans();
    }
}
