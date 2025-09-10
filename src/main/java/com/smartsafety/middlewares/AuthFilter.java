package com.smartsafety.middlewares;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Very small auth filter — replace with JWT filter for production.
 */
@Component
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getRequestURI();
        // allow open endpoints
        if (path.startsWith("/api/auth") || path.startsWith("/api/chatbot")) {
            chain.doFilter(req, res);
            return;
        }

        // In this simplified demo we accept a header "X-User-Email" as authenticated user
        String userEmail = request.getHeader("X-User-Email");
        if (userEmail == null || userEmail.isBlank()) {
            res.getWriter().write("{\"error\":\"Unauthorized - add X-User-Email header for demo\"}");
            ((javax.servlet.http.HttpServletResponse) res).setStatus(401);
            return;
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {}
}
