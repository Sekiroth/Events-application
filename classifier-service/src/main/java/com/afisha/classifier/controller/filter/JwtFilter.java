package com.afisha.classifier.controller.filter;

import static org.apache.logging.log4j.util.Strings.isEmpty;

import java.io.IOException;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.afisha.classifier.controller.utils.JwtTokenUtil;
import com.afisha.classifier.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final RestTemplate restTemplate;

    public JwtFilter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        if (!JwtTokenUtil.validate(token)) {
            chain.doFilter(request, response);
            return;
        }

        // Get user identity and set it on the spring security context

        String url = "http://user-service:82/api/v1/users/me";
        String newToken = "Bearer " + JwtTokenUtil.generateAccessToken(JwtTokenUtil.getUsername(token));
        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, newToken);
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        User user = new User();

        try {
            ResponseEntity<User> response2 =
                    restTemplate.exchange(url, HttpMethod.GET, entity, User.class);
            HttpStatus status = response2.getStatusCode();

            if(status.is2xxSuccessful()) {
                User user1 = response2.getBody();
                user.setMail(user1.getMail());
                user.setStatus(user1.getStatus());
                user.setRole(user1.getRole());
            }

        } catch (HttpClientErrorException e) {
            throw new RuntimeException("client Exception");
        }

        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(
                user, null,
                user == null ?
                        List.of() : user.getAuthorities()
        );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}