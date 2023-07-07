package com.example.tushusys.jwt.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class PayloadDto {
    private String username;
    private Long iat;
    private Long exp;
    private String jti;
    private String sub;
    private List<String> authorities;

}
