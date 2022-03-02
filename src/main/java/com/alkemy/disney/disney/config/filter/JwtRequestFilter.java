package com.alkemy.disney.disney.config.filter;

import com.alkemy.disney.disney.service.JwtUtils;
import com.alkemy.disney.disney.service.UserDetailCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailCustomService userDetailCustomService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
        {

            final String authorizationHeader = request.getHeader("Authorization");
            String username = null;
            String jwt  = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ") ){
                jwt = authorizationHeader.substring(7);
                username = jwtUtils.extractUsername(jwt);
            }

            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = this.userDetailCustomService.loadUserByUsername(username);

                if(jwtUtils.validateToken(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken authReq =
                            new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                            //TODO cambie setAuthentication por authenticate en authmanager
                    Authentication auth = authenticationManager.authenticate(authReq);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
            filterChain.doFilter(request, response);
        }
    }

