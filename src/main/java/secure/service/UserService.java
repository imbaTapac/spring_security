package secure.service;

import secure.entity.User;

import java.util.LinkedList;
import java.util.List;

public interface UserService {

    void save(User user);
    User findByUsername(String username);

}
