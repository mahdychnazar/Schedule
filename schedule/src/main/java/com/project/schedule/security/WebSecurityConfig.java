package com.project.schedule.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.HeaderWriterFilter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private final  UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder, UserDetailsServiceImpl userDetailsService){

        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/", "/registration", "/h2-console/**").permitAll()
                    .antMatchers("/students/**", "/courses/**").hasAuthority("USER")
                    .antMatchers("/update/**","/delete/**", "/create/**").hasAuthority("ADMIN")
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();

        http.addFilterAfter(new CustomFilter(), HeaderWriterFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
    }
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
@Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
}*/


/*@Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails usr = User.builder()
                .username("u")
                .password(passwordEncoder.encode("p"))
                .roles(Role.USER.name())
                .build();


        UserDetails usr1 = User.builder()
                .username("uu")
                .password(passwordEncoder.encode("p"))
                .roles(Role.ADMIN.name())
                .build();

        UserDetails usr2 = User.builder()
                .username("uuu")
                .password(passwordEncoder.encode("p"))
                .roles(Role.SUBADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(usr, usr1, usr2);
    }*/


}
