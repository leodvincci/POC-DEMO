package com.csc363.group2.poc_demo.security.config;

import com.csc363.group2.poc_demo.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String[] WHITE_LIST_URLS = {
            "/register",
            "/style.css",
            "/register.js",
            "/welcome.html",
            "/registration.html",
            "/login",
            "/public/register.js",
            "/index.html",
            "/h2-console",
            "/api/v*/registration/**",
            "/api/v*/resetpassword/**",
            "/api/v*/updateuserinfo/**",
            "/api/v*/**",
            "/allusers",
            "/removeuser",

    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers(WHITE_LIST_URLS).permitAll()
                    .antMatchers("/login*").permitAll()
                    .antMatchers("/indexAdminPanel.html").hasAuthority("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin().and()
                .httpBasic();
        ;

        http.headers().frameOptions().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:63342","http://localhost:8080","http://localhost:**")); //URLs you want to allow
//        configuration.setAllowedMethods(Arrays.asList("GET","POST")); //methods you want to allow
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

}
