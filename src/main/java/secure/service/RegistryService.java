package secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secure.DAO.RegistryDAO;
import secure.entity.Users;

/**
 * Created by Тарас on 30.03.2017.
 */
@Service
public class RegistryService {
    @Autowired
    private RegistryDAO registryDAO;

    @Transactional
    public void addUser(Users users){
        registryDAO.add(users);
    }
}
