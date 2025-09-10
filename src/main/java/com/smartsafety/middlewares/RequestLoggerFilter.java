package com.smartsafety.middlewares;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RequestLoggerFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggerFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest r = (HttpServletRequest) req;
        logger.info("Request: {} {}", r.getMethod(), r.getRequestURI());
        chain.doFilter(req, res);
    }
}
