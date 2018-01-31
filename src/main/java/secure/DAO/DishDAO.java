package secure.DAO;

import secure.entity.Dish;
import secure.entity.Users;

import java.util.List;

/**
 * Created by Тарас on 30.03.2017.
 */

public interface DishDAO {
    void addDish(Dish dish);
    void deleteDish(long[] ids);
    void updateDish (long id);
    byte[] getDishPhoto(Long id);
    List <Dish> getDishesID();
    List<String[]> getDishName(long id);
    List <String[]> getDishIng(long id);
    List <String[]> getDishPrice(long id);
    }

