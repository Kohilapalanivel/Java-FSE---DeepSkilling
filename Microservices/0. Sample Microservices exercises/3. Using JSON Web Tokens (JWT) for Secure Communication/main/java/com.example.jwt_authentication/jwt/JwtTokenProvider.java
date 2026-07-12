package com.example.jwt_authentication.jwt;
import java.util.Collections;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.example.jwt_authentication.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtTokenProvider 
{
    @Autowired
    private JwtConfig jwtConfig;
    public String createToken(String username) 
    {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);
        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity).signWith(SignatureAlgorithm.HS256, jwtConfig.getSecret()).compact();
    }
    public boolean validateToken(String token) 
    {
        try
        {
            Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token);
            return true;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
    public String getUsername(String token) 
    {
        return Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token).getBody().getSubject();
    }
    public Authentication getAuthentication(String token) 
    {
       String username = getUsername(token);
        return new UsernamePasswordAuthenticationToken(username,"",Collections.emptyList());
    }
}
