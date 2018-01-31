package secure.DAO;

import org.springframework.stereotype.Repository;
import secure.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Тарас on 30.03.2017.
 */
@Repository
public class RegistryDAOImpl implements RegistryDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(Users users) {
      entityManager.merge(users);
    }
}
