package com.yys.spring.license.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleServiceFactoryTest {
    @Autowired
    private RuleServiceFactory ruleServiceFactory;

    @Test
    public void test(){
        ruleServiceFactory.invokeMethod("1");
    }

    @Test
    public void test2(){
        for (int i = 1; i < 4; i++) {
            ruleServiceFactory.invokeMethod(String.valueOf(i));
        }
    }

}
