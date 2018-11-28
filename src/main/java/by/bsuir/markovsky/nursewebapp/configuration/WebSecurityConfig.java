package by.bsuir.markovsky.nursewebapp.configuration;

import by.bsuir.markovsky.nursewebapp.service.UserDetailsServiceImpl;
import by.bsuir.markovsky.nursewebapp.util.EncryptedPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static by.bsuir.markovsky.nursewebapp.constant.MappingConstant.*;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Value("${user.admin.username}")
    private String adminUsername;
    @Value("${user.admin.password}")
    private String adminPassword;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Default admin role
        auth.inMemoryAuthentication()
                .withUser(adminUsername)
                .password(EncryptedPasswordUtil.encrytePassword(adminPassword))
                .roles("ADMIN");
        // Setting Service to find User in the database. And Setting PassswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // The pages does not require login
        http.authorizeRequests().antMatchers(HOME, ABOUT_US, LOGIN, DENIED, NOT_FOUND, REGISTRATION, ERROR, SERVICE, NURSE_REGISTRATION, LOAD_DATA_HOME, LOAD_DATA_SERVICE).permitAll();
        //For authenticated users
        http.authorizeRequests().antMatchers(LOGOUT).access("isAuthenticated()");

        // If no login, it will redirect to /login page.
        // For USER only.
        http.authorizeRequests().antMatchers(USER, SUBSCRIBE, UNSUBSCRIBE, LOAD_DATA_USER).access("hasAnyRole('USER')");

        // For NURSE only.
        http.authorizeRequests().antMatchers(NURSE, ADD_SERVICE, EDIT_SERVICE, DELETE_SERVICE, GET_SERVICE, GET_ALL_SERVICES, LOAD_DATA_NURSE).access("hasRole('NURSE')");

        // For ADMIN only.
        http.authorizeRequests().antMatchers(ADMIN, EDIT_SERVICE, DELETE_SERVICE, GET_SERVICE, GET_ALL_SERVICES,
                ADD_NEWS, EDIT_NEWS, DELETE_NEWS, GET_NEWS, GET_ALL_NEWS, LOAD_DATA_ADMIN).access("hasRole('ADMIN')");

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage(DENIED);

        // Config for Login Form
        http.authorizeRequests().and().formLogin()
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage(LOGIN)
                .defaultSuccessUrl(HOME)
                .failureUrl(LOGIN + ERROR_QUERY)
                .usernameParameter("username")
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl(LOGOUT).logoutSuccessUrl(HOME);
    }

}
