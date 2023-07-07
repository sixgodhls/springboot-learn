package com.example.tushusys.jwt.filter;

import cn.hutool.crypto.SecureUtil;
import com.example.tushusys.jwt.dto.PayloadDto;
import com.example.tushusys.jwt.utils.JwtUtil;
import com.nimbusds.jose.JOSEException;
import org.omg.IOP.ServiceContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        System.out.println(token);
        if(token == null){
            filterChain.doFilter(request,response);
            return;
        }
        try {
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(token));
            filterChain.doFilter(request,response);
            return;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JOSEException e) {
            e.printStackTrace();
        }
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token) throws ParseException, JOSEException {
        PayloadDto payloadDto = JwtUtil.verifyTokenByHMAC(token, SecureUtil.md5(JwtUtil.DEFAULT_SECRET));
        String username = payloadDto.getUsername();
        List<String> authorities = payloadDto.getAuthorities();
        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        authorities.forEach(authority->{
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authority));
        });
        if(username !=null){
        return new UsernamePasswordAuthenticationToken(username,null,simpleGrantedAuthorities);
        }
        return null;
    }
}


