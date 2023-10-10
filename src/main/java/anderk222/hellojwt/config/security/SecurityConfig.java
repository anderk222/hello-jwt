package anderk222.hellojwt.config.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import anderk222.hellojwt.util.Encryptor;
import anderk222.hellojwt.util.KeyGenerator;
import anderk222.hellojwt.util.TokenUtil;

@Configuration
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Value("${key.password}")
    private String privatePassword;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

        TokenUtil tokenUtil = new TokenUtil(jwtSecret);

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(tokenUtil);
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        http.csrf((c) -> c.disable())
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/register")
                        .permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(new JwtAuthorizationFilter(tokenUtil), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(userDetailsService).passwordEncoder(encoder());

        return builder.build(); 

    }

    @Bean 
    PasswordEncoder encoder() throws InvalidKeySpecException, NoSuchAlgorithmException {

        return new Encryptor(KeyGenerator.getKey(256, privatePassword));

    }



}