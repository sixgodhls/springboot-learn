package com.example.tushusys.jwt.utils;

import cn.hutool.json.JSONUtil;
import com.example.tushusys.jwt.dto.PayloadDto;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;

import java.text.ParseException;
import java.util.Date;

public class JwtUtil {
    public static final String DEFAULT_SECRET="hhj";

    public static String generateTokenByHMAC(String payloadStr,String secret) throws JOSEException {
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256).type(JOSEObjectType.JWT).build();
        Payload payload = new Payload(payloadStr);
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        JWSSigner macSigner = new MACSigner(secret);
        jwsObject.sign(macSigner);
        return jwsObject.serialize();
    }

    public static PayloadDto verifyTokenByHMAC(String token,String secret) throws ParseException, JOSEException {
        JWSObject jwsObject = JWSObject.parse(token);
        MACVerifier verifier = new MACVerifier(secret);
        if(!jwsObject.verify(verifier)){
            throw new JOSEException("签名不合格");
        }
        String payLoad = jwsObject.getPayload().toString();
        PayloadDto payloadDto = JSONUtil.toBean(payLoad, PayloadDto.class);
        if(payloadDto.getExp()<new Date().getTime()){
            throw new JOSEException("token过期");
        }
        return payloadDto;
    }
}
