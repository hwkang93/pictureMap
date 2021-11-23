package hwkang.pictureMap.config;

import hwkang.pictureMap.auth.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final OAuth2UserService customOAuthUserService;

    private final static String[] PERMIT_ALL_PATTERNS = {"/login", "/css/**", "/images/**", "/js/**"};
    private final static String[] LOGIN_USER_ROLE_PATTERNS = {"/test"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers(PERMIT_ALL_PATTERNS).permitAll()
                    .antMatchers(LOGIN_USER_ROLE_PATTERNS).hasRole(Role.LOGIN_USER.name())
                    .anyRequest().authenticated()
                //디폴트 로그인 화면이 아닌, 커스텀 로그인 화면을 구현할 경우 필요.
                //디폴트 로그인 화면을 사용해도 되는 경우에는 필요 없음.
                .and()
                    .oauth2Login()
                    .loginPage("/login")
                .and()
                    .logout()
                    .logoutSuccessUrl("/login")
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuthUserService);
    }
}
