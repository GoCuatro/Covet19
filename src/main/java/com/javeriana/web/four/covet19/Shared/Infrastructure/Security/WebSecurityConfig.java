package com.javeriana.web.four.covet19.Shared.Infrastructure.Security;

import com.javeriana.web.four.covet19.Shared.Infrastructure.Security.XMLSecurity.SecurityDirectives;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurity obj = http.csrf().disable()
                .addFilterAfter(new JWTAuthFilter(), UsernamePasswordAuthenticationFilter.class);
        SecurityDirectives.directives.forEach(xmlSecurityDirective -> {
            try {
                if(xmlSecurityDirective.getMethod() == null){
                    obj.authorizeRequests().antMatchers(xmlSecurityDirective.getEndpoint()).hasAuthority(xmlSecurityDirective.getAuthority());
                }else{
                    obj.authorizeRequests().antMatchers(xmlSecurityDirective.getMethod(), xmlSecurityDirective.getEndpoint()).hasAuthority(xmlSecurityDirective.getAuthority());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        obj.authorizeRequests().antMatchers("*").permitAll();
    }
}
