package com.example.tushusys.config.handle;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWTUtil;
import com.example.tushusys.controller.result.BaseResult;
import com.example.tushusys.jwt.dto.PayloadDto;
import com.example.tushusys.jwt.utils.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JOSEException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails userDetails=(UserDetails)principal;
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            List<String> authoritiesList = new ArrayList<>();
            authorities.forEach(authority->{
                authoritiesList.add(authority.getAuthority());
            });

            Date now = new Date();
            DateTime exp = DateUtil.offsetSecond(now, 60 * 60);
            PayloadDto payloadDto = PayloadDto.builder()
                    .sub(userDetails.getUsername())
                    .iat(now.getTime())
                    .exp(exp.getTime())
                    .jti(UUID.randomUUID().toString())
                    .username(userDetails.getUsername())
                    .authorities(authoritiesList)
                    .build();
            String token=null;
            try{
                token = JwtUtil.generateTokenByHMAC(JSONUtil.toJsonStr(payloadDto)
                        , SecureUtil.md5(JwtUtil.DEFAULT_SECRET));
                response.setHeader("Authorization",token);
                response.setContentType("application/json;charset=UTF-8");
                BaseResult result = new BaseResult(HttpServletResponse.SC_OK,"OK");
                response.setStatus(HttpServletResponse.SC_OK);
                PrintWriter writer = response.getWriter();
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(result);
                writer.print(json);
                writer.close();
            } catch (JOSEException e) {
                e.printStackTrace();
            }
        }
    }
}
