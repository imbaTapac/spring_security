package secure.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import secure.entity.User;

/**
 * Created by Тарас on 01.04.2017.
 */

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}