package com.logicorp.security.filter;

import com.logicorp.security.jwt.JwtService;
import com.logicorp.security.tenant.MultiTenantContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.Filter;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthFilter implements Filter {

    private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

        try {

            String token = request.getParameter("Authorization");

            String tenant = jwtService.extractTenant(token);

            MultiTenantContext.setTenant(tenant);

            chain.doFilter(request, response);

        } catch (Exception e) {
            throw new RuntimeException("Unauthorized");
        } finally {
            MultiTenantContext.clear();
        }
    }
}