package com.jwt.springsecurity.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.sql.DataTruncation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTHelper {
    //Validity of a token from time of issue
    public static final long JWT_TOKEN_VALIDITY = 5*60*60;

    //secret key to generate jwt
    private String secret = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaajjjjJJJJJJJJJJJJNKJUSBHACLIUSDBCLISUFHLVEIUHMZLIMVZIULWURLKHTMVZUTHZIUTHVIEUTHZOITHVMZOUIZLTUHZTVHZ8IVTGI";




    //get username from jwt
    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
     final Claims claims =  getAllClaimsFromToken(token);
        return claimResolver.apply(claims);
    }

    public Date getExpirationFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }
    private Boolean isTokenExpired(String token){
        final Date expiration =  getExpirationFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails u){
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, u.getUsername() );
    }

    private String doGenerateToken(Map<String, Object> claims, String user) {
        claims.put("amy","gop");
        return Jwts.builder().setClaims(claims).setSubject(user).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails user){
        final String username = getUsernameFromToken(token);
        if(username.equals(user.getUsername()) && !isTokenExpired(token))
            return true;
        return false;
    }


}
