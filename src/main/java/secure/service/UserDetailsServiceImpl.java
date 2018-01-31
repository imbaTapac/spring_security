package secure.service;

import org.springframework.transaction.annotation.Transactional;
import secure.DAO.UserDAO;
import secure.entity.Role;
import secure.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //создаем пользователя которого ищем по имени в БД
        User user = userService.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException(username + " not found");
        }
        // разрешение на вход
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        // запихиваем все роли в разрешения на вход
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),grantedAuthorities);

        return userDetails;

    }
}