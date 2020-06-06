package com.ada.nflow.bean;

import org.springframework.beans.factory.InitializingBean;

public class SimpleBeans implements InitializingBean {

    public SimpleBeans(){
        System.out.println("SimpleBeans constructor ....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet .....");
    }
}
