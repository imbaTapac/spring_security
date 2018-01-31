package secure.service;

/**
 * Created by Тарас on 01.04.2017.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}