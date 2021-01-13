package com.example.java8.chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 继承RecursiveTask来创建可以用于分支/合并框架的任务
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10000;

    public static long forkJoinSum(long n){
        long[] numberArray = LongStream.rangeClosed(1,n).toArray();
        //创建一个ForkJoinTask(RecursiveTask)
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numberArray);
        //创建一个新的ForkJoinPool，并把任务传递给它的调用方法
        //在实际情况下，多个ForkJoinPool没有意义，一般实例化异常，然后
        //把实例保存在静态字段中，使之成为单例
        return new ForkJoinPool().invoke(task);
    }

    public ForkJoinSumCalculator(long[] numbers){
        this(numbers,0,numbers.length);
    }
    private ForkJoinSumCalculator(long[] numbers,int start, int end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if(length <= THRESHOLD){
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers,start,start+length/2);
        //利用另一个ForkJoinPool线程异步执行新创建的子任务
        leftTask.fork();
        //创建一个任务为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers,start+length/2,end);
        //同步执行第二个任务，有可能允许进一步递归划分
        Long rightResult = rightTask.compute();
        //读取第一个子任务的结果，如果尚未完成就等待
        Long leftResult = leftTask.join();
        return rightResult + leftResult;
    }

    /**
     * 在子任务不在可分时计算结果的简单算法
     * @return
     */
    private long computeSequentially(){
        long sum = 0;
        for (int i =start;i<end;i++){
            sum += numbers[i];
        }
        return sum;
    }

}
