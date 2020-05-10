package com.microservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.UUID;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class AuthHeaderFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // getting the current HTTP request that is to be handle
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        // printing the detail of the request
        logger.info("request -> {} request uri-> {}", request, request.getRequestURI());
        return null;
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        if (!request.getRequestURI().equals("/authenticate")) {
//            String authHeader = request.getHeader("Authorization");
//            if (authHeader != null) {
//                ctx.addZuulRequestHeader("Authorization", authHeader);
//            } else {
//                ctx.setSendZuulResponse(false);
//                ctx.setResponseStatusCode(401);
//            }
//        }
//        return null;
    }

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

}
