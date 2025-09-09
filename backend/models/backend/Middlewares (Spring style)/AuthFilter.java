package com.smartsafety.middlewares;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("AuthFilter: " + req.getMethod() + " " + req.getRequestURI());
        // TODO: add JWT verification
        chain.doFilter(request, response);
    }
}
