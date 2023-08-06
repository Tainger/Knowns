package com.bonbon.knowns.configuration.trace;


import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

/**
 * @author jiazhiyuan
 * @date 2023/8/7 12:24 AM
 */

@Component
public class TraceIdFilter implements Filter {

    public static final String TRACE_ID = "traceId";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String traceId = Optional.ofNullable(httpServletRequest.getHeader(TRACE_ID)).orElse(UUID.randomUUID().toString());
        MDC.put(TRACE_ID, traceId);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(TRACE_ID);
        }
    }
}



    
