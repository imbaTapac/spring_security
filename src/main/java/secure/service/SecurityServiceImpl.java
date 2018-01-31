package secure.service;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/* * Created by Тарас on 01.04.2017.
Автологин
 */

@Service
public class SecurityServiceImpl implements SecurityService {

    // Логгер
    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    //Менеджер аутентефикации
    @Autowired
    public AuthenticationManager authenticationManager;


    @Autowired
    public UserDetailsService userDetailsService;

    @Override
    public String findLoggedInUsername() {
        // получаем утентефикацию и ее детали
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        //если детали есть екземпляром  возвращаем имя залогиненого пользователя
        if (userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }

        return null;
    }

    @Override
    public void autoLogin(String username, String password) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        //авторизация
        authenticationManager.authenticate(authenticationToken);

        //если токен авторизован то получаем контекст и ставим авторизацию
        if (authenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            logger.debug(String.format("Successfully %s auto logged in", username));
        }
    }
}