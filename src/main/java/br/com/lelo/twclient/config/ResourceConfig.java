package br.com.lelo.twclient.config;

public class ResourceConfig{

}
/**
@Configuration
@EnableResourceServer
@Profile(value = "default")
public class ResourceConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("twclientresource");
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        String oauthRead = "#oauth2.hasScope('read')";
        String oauthWrite = "#oauth2.hasScope('write')";

        httpSecurity
                .cors()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers("/**")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .antMatchers(HttpMethod.GET, "/**").access(oauthRead)
                .antMatchers(HttpMethod.OPTIONS, "/**").access(oauthRead)
                .antMatchers(HttpMethod.POST, "/**").access(oauthWrite)
                .antMatchers(HttpMethod.PUT, "/**").access(oauthWrite)
                .antMatchers(HttpMethod.PATCH, "/**").access(oauthWrite)
                .antMatchers(HttpMethod.DELETE, "/**").access(oauthWrite);
    }

    @Bean
    public CorsConfigurationSource corsConfig() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
**/