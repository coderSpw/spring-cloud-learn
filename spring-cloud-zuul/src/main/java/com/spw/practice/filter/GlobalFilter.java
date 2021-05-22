package com.spw.practice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description  token校验
 * @Author spw
 * @Date 2021/5/22
 */
@Slf4j
@Component
public class GlobalFilter extends ZuulFilter {
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
        RequestContext cxt = RequestContext.getCurrentContext();
        HttpServletRequest request = cxt.getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            log.error("token is empty");
            cxt.setSendZuulResponse(false);
            cxt.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            try {
                cxt.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                log.error(e.getMessage());
                return null;
            }
        }
        log.info("请求token:{}", token);
        return null;
    }
}
