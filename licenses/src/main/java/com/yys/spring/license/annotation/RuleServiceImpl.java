package com.yys.spring.license.annotation;

import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements IRuleService {

    @Override
    @RuleSequenceNoAnnotation(value = "1",msg = "执行风控规则1方法")
    public boolean test1() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    @RuleSequenceNoAnnotation(value = "2",msg = "执行风控规则2方法")
    public boolean test2() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    @RuleSequenceNoAnnotation(value = "3",msg = "执行风控规则3方法")
    public boolean test3() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    @RuleSequenceNoAnnotation(value = "4",msg = "执行风控规则4方法")
    public boolean test4() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
