package secure.DAO;

import secure.entity.Users;

import java.util.List;

/**
 * Created by Тарас on 30.03.2017.
 */
public interface RegistryDAO {
    void add(Users users);
    ////void delete(Users users);
   // void delete(long[] ids);
   // List<Users> list(Users group);
   // List<Users> list(String pattern);
}
