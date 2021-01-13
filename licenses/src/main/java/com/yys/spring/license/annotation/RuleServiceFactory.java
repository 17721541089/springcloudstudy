package com.yys.spring.license.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public final class RuleServiceFactory<T> {

    @Autowired
    private IRuleService ruleService;

    /**
     * indexSet：风控规则方法对应唯一值
     * allFlag:true 风控规则方法方法全部通过
     * false：风控规则方法任意一个方法通过就通过
     * return为true,表示规则通过 false 规则不通过
     */
    public boolean invokeMethods(Set<String> indexSet, boolean allFlag){
        if(allFlag){
            Boolean resultFlag;
            for (String index:indexSet) {
                resultFlag = (Boolean)invokeMethod(index);
                // 无任何方法、index找不到对应的方法时默认是通过的
                if(resultFlag != null && !resultFlag){
                    return false;
                }
            }
            return true;
        }else {
            Boolean resultFlag;
            for (String index:indexSet) {
                resultFlag = (Boolean)invokeMethod(index);
                // 无任何方法、index找不到对应的方法时默认是通过的
                if(resultFlag !=null || resultFlag){
                    return true;
                }
            }
            return false;
        }
    }


    /**
     * 无任何方法时默认是通过的
     * @param index
     * @return
     */
    public T invokeMethod(String index){
        Class<?>  ruleServiceImplClass = ruleService.getClass();
        Method[] methods = ruleServiceImplClass.getDeclaredMethods();
        if(methods == null || methods.length == 0){
            log.info("IRuleService接口无任何方法");
            return null;
        }
        T result = null;
        for (Method method:methods) {
            RuleSequenceNoAnnotation ruleSequenceNoAnnotation =  method.getAnnotation(RuleSequenceNoAnnotation.class);
            if(ruleSequenceNoAnnotation == null ){
                continue;
            }
            String ruleIndex = ruleSequenceNoAnnotation.value();
            if(ruleIndex.equals(index)){
                try {
                    result = (T) method.invoke(ruleService,new Object[]{});
                    log.info(ruleSequenceNoAnnotation.msg()+" "+result);
                    return result;
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage());
                } catch (InvocationTargetException e) {
                    log.error(e.getMessage());
                }
            }
        }
        log.info("index："+index+"找不到对应的方法");
        return null;
    }



    @PostConstruct
    public void init() throws Exception{
        Class<?>  ruleServiceImplClass = ruleService.getClass();
        Method[] methods = ruleServiceImplClass.getDeclaredMethods();
        Set<String> ids = new HashSet<>();
        int idsLength = 0;
        for (Method method:methods) {
            RuleSequenceNoAnnotation ruleSequenceNoAnnotation =  method.getAnnotation(RuleSequenceNoAnnotation.class);
            if(ruleSequenceNoAnnotation != null ){
                ids.add(ruleSequenceNoAnnotation.value());
                idsLength++;
            }
        }
        if(idsLength != ids.size()){
            throw new Exception("IRuleService接口实现类，存在方法注解@RuleSequenceNoAnnotation的value非唯一");
        }
    }
}
