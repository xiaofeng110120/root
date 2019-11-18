package com.local.admin.service.hystrix;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.properties.HystrixProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Setter
@Getter
public class DBAwareStrategy extends HystrixConcurrencyStrategy {

    private HystrixConcurrencyStrategy springCloudExistHystrixConcurrencyStrategy;//spring 已存在的HystrixConcurrencyStrategy

    public DBAwareStrategy(HystrixConcurrencyStrategy springCloudExistHystrixConcurrencyStrategy) {
        this.springCloudExistHystrixConcurrencyStrategy = springCloudExistHystrixConcurrencyStrategy;
    }


    @Override
    public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
        return springCloudExistHystrixConcurrencyStrategy != null ? springCloudExistHystrixConcurrencyStrategy.getBlockingQueue(maxQueueSize) : super.getBlockingQueue(maxQueueSize);
    }

    @Override
    public <T> HystrixRequestVariable<T> getRequestVariable(HystrixRequestVariableLifecycle<T> rv) {
        return springCloudExistHystrixConcurrencyStrategy != null ? springCloudExistHystrixConcurrencyStrategy.getRequestVariable(rv) : super.getRequestVariable(rv);
    }

    @Override
    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize, HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        return springCloudExistHystrixConcurrencyStrategy != null
                ? springCloudExistHystrixConcurrencyStrategy.getThreadPool(threadPoolKey, corePoolSize,
                maximumPoolSize, keepAliveTime, unit, workQueue)
                : super.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize,
                keepAliveTime, unit, workQueue);
    }

    @Override
    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixThreadPoolProperties threadPoolProperties) {
        return springCloudExistHystrixConcurrencyStrategy != null
                ? springCloudExistHystrixConcurrencyStrategy.getThreadPool(threadPoolKey, threadPoolProperties)
                : super.getThreadPool(threadPoolKey, threadPoolProperties);
    }

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return  springCloudExistHystrixConcurrencyStrategy != null
                ? springCloudExistHystrixConcurrencyStrategy.wrapCallable(new DBCallable(callable, DynamicDataSourceContextHolder.peek()))
                : super.wrapCallable(new DBCallable(callable, DynamicDataSourceContextHolder.peek()));
    }
}
