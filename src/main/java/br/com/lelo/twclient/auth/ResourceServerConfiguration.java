package br.com.lelo.twclient.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static String oauthHashRead = "#oauth2.hasScope('read')";
    private static String oauthHashWrite = "#oauth2.hasScope('write')";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("resources");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.requestMatchers()
                .antMatchers("/**")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .antMatchers(HttpMethod.GET, "/**").access(oauthHashRead)
                .antMatchers(HttpMethod.OPTIONS, "/**").access(oauthHashRead)
                .antMatchers(HttpMethod.POST, "/**").access(oauthHashWrite)
                .antMatchers(HttpMethod.PUT, "/**").access(oauthHashWrite)
                .antMatchers(HttpMethod.DELETE, "/**").access(oauthHashWrite);
    }
}