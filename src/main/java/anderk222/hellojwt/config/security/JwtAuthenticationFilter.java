package anderk222.hellojwt.config.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import anderk222.hellojwt.util.TokenUtil;
import io.jsonwebtoken.lang.Collections;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private TokenUtil tokenUtil;

    public JwtAuthenticationFilter(TokenUtil tokenUtil){

        this.tokenUtil = tokenUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        Auth auth = new Auth();

        try {

            auth = new ObjectMapper().readValue(request.getReader(), Auth.class);

        } catch (Exception ex) {
 
        }

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                auth.getName(), auth.getPassword(), Collections.emptyList());

        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws java.io.IOException, ServletException {
        
        UserDetailsImpl user = (UserDetailsImpl) authResult.getPrincipal();


        String token = tokenUtil.createToken(user.claims());

        response.addHeader("Authorization", "Bearer "+token);

        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
