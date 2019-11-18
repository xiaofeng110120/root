//package com.local.admin.config;
//
//import com.local.admin.service.util.DBContext;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//public class DynamicDataSource extends AbstractRoutingDataSource {
//    @Override
//    protected Object determineCurrentLookupKey() {
//        String s = DBContext.get();
//        return s;
//    }
//}
