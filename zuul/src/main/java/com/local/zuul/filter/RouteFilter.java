//package com.local.zuul.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedInputStream;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Random;
//
//@Component
//public class RouteFilter extends ZuulFilter {
//
//
//    private ProxyRequestHelper helper = new ProxyRequestHelper();
//
//    private RestTemplate restTemplate = new RestTemplate();
//
//
//    @Override
//    public String filterType() {
//        return "route";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        Random random = new Random();
//        int i = random.nextInt(10);
//        if (i < 5) {
//            this.sendReq();
//            try {
//                String s = "{\"status\":200,\"ss\":555}";
//                ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(s.getBytes());
//                this.helper.setResponse(200,tInputStringStream,null);
//            } catch (IOException e) {
//
//            }
//        } else {
//            System.out.println("ssssssssssssssssssssssssssssss");
//        }
//
//
//        return null;
//    }
//
//    private void sendReq() {
//        try {
//            RequestContext context = RequestContext.getCurrentContext();
//            HttpServletRequest request = context.getRequest();
//
//            MultiValueMap<String, String> headers = this.helper
//                    .buildZuulRequestHeaders(request);
//            MultiValueMap<String, String> params = this.helper
//                    .buildZuulRequestQueryParams(request);
//            InputStream requestEntity = request.getInputStream();
//
//            String verb = request.getMethod();
//            if ("GET".equals(verb)) {
//                restTemplate.getForEntity("http://localhost:8551/v1/mgt/sys-user/add-sys-user", Object.class);
//            }
//            if ("POST".equals(verb)) {
//                restTemplate.postForEntity("http://localhost:8551/v1/mgt/sys-user/add-sys-user", requestEntity, Object.class);
//            }
//        } catch (IOException e) {
//
//        }
//
//    }
//
//
//}
