package com.example.java8.chapter8.ChainResponsibilityPattern;

/**
 * 责任链模式是为了避免请求发送者与多个请求处理者耦合在一起，
 * 将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；
 * 当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 *
 */
public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;
    public void setSuccessor(ProcessingObject<T> successor){
        this.successor = successor;
    }
    public T handle(T input){
        //调用当前责任链的处理方法
        T r = handlerWork(input);
        //如果有下一个节点，那么将当前责任链的处理方法的值传递给下一个责任链
        //注意：处理链的所有处理的请求参数都是一个类型T
        if(successor != null){
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handlerWork(T input);
}
