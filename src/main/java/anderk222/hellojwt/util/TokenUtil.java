package anderk222.hellojwt.util;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenUtil {

    private SecretKey secretKey;

    public TokenUtil(SecretKey secret) throws Exception {

        this.secretKey = secret;

    }

    private final static long expiration = 121212121l;

    public String createToken(Map<String, ?> claims) {

        Map<String, Object> data = new HashMap<>();

        data.put("name", data);

        Date dateExpiration = new Date(System.currentTimeMillis() + expiration);

        String token = Jwts.builder().claims(claims)
                .expiration(dateExpiration).expiration(dateExpiration)
                .signWith(secretKey).compact();
        
        return token;
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token) {

        Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();

        String name = claims.getSubject();

        return new UsernamePasswordAuthenticationToken(name, null, Collections.emptyList());

    }

}
