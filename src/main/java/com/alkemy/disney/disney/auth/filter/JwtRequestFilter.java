package com.alkemy.disney.disney.auth.filter;

import com.alkemy.disney.disney.auth.service.JwtUtils;
import com.alkemy.disney.disney.auth.service.UserDetailCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailCustomService userDetailCustomService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        throws ServletException, IOException{

            final String authorizationHeader = request.getHeader("Authorization");

            String username = null;
            String jwt  = null;

            if (username != null && authorizationHeader.startsWith("Bearer ") ){
                jwt = authorizationHeader.substring(7);
                username = jwtUtils.extractUsername(jwt);
            }

            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = this.userDetailCustomService.loadUserByUsername(username);

                if(jwtUtils.validateToken(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken authReq =
                            new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                    Authentication auth = authenticationManager.setAuthentication(authReq);
                    //set auth in context
                    SecurityContextHolder.getContext().setAuthentication(auth);

                }

            }
            filterChain.doFilter(request, response);
        }
    }
}
