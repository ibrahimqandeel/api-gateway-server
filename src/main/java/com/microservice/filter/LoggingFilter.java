package com.microservice.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class LoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        // TODO Auto-generated method stub
        // getting the current HTTP request that is to be handle
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        // printing the detail of the request
        logger.info("request -> {} request uri-> {}", request, request.getRequestURI());
        return null;
    }

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

}
