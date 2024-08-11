package com.sparta.msa_exam.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        http.sessionManagement((sessionManagement) ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.authorizeHttpRequests(authorize -> authorize
                // /auth/signIn 경로에 대한 접근을 허용합니다. 이 경로는 인증 없이 접근할 수 있습니다.
                .requestMatchers("/auth/signIn")
                .permitAll()
                // 그 외의 모든 요청은 인증이 필요합니다.
                .anyRequest()
                .authenticated());


        return http.build();
    }
}
