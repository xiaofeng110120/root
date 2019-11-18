package com.local.admin.service.hystrix;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;

import java.util.concurrent.Callable;

public class DBCallable<V> implements Callable<V> {


    private final Callable<V> delegate;

    private String db;

    DBCallable(Callable<V> delegate, String db) {
        this.delegate = delegate;
        this.db = db;
    }


    @Override
    public V call() throws Exception {
        DynamicDataSourceContextHolder.push(db);
        try {
            return delegate.call();
        } finally {
            this.db = null;
        }
    }
}
