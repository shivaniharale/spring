package com.example.employeepayroll.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID= -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY=5*60*60;

    private static final java.util.logging.Logger LOGGER= Logger.getLogger(String.valueOf(JwtTokenUtil.class));

    @Value("${jwt.secretkey}")
    private String secretKey;

    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver){

        final Claims claims=getAllClaimsFromToken(token);
        return  claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        final Date expiration=getExpirationDateFromToken(token);
        return  expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails, HttpServletRequest request){
        Map<String,Object> claims=new HashMap<>();

        LOGGER.info("RemoteAddress:"+request.getRemoteAddr());

        claims.put("ip",request.getRemoteAddr());

        return doGenerateToken(claims,userDetails.getUsername());
    }

//    private static String getClientIp(HttpServletRequest httpServletRequest){
//        String remoteAddress="";
//        if(httpServletRequest != null){
//            remoteAddress=httpServletRequest.getHeader("X-FORWARDED-FOR");
//            if(remoteAddress==null || remoteAddress.isEmpty()){
//                remoteAddress=httpServletRequest.getRemoteAddr();
//            }
//        }
//        return remoteAddress;
//    }




    private String doGenerateToken(Map<String,Object> claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512,secretKey).compact();
    }

    public Boolean validateToken(String token,UserDetails userDetails){
        final String userName=getUserNameFromToken(token);
        return (userName.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

}
