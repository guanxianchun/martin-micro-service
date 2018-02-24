package com.martin.api.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.servlet.http.HttpServletRequest;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2/22/18 4:32 PM
 * Descrition
 */

public class AccessTokenFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(AccessTokenFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String url = request.getRequestURL().toString();
        logger.info(url);
        if("/login".equals(url)){
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess",true);
        }else{
            //TODO check token info
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess",true);
        }
        return null;
    }
}
