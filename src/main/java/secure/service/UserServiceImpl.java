package secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import secure.DAO.RoleDAO;
import secure.DAO.UserDAO;
import secure.entity.Role;
import secure.entity.User;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;

    @Override
    public void save(User user) {

        user.setPassword(shaPasswordEncoder.encodePassword(user.getPassword(),null));
        System.out.println(user.getPassword());
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(1L));
        user.setRoles(roles);
        userDAO.save(user);

    }

    @Override
    public User findByUsername(String username) {

        return userDAO.findByUsername(username);
    }
}
