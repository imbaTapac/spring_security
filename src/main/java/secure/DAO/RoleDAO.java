package secure.DAO;

import secure.entity.Role;

/**
 * Created by Тарас on 01.04.2017.
 */
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {

}