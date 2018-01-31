package secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secure.DAO.DishDAO;
import secure.entity.Dish;

import java.util.List;

/**
 * Created by Тарас on 30.03.2017.
 */
@Service
public class DishService {
    @Autowired
    private DishDAO dishDAO;

    @Transactional
    public void addContact(Dish dish) {
        dishDAO.addDish(dish);
    }



    @Transactional(readOnly=true)
    public List<Dish> listID() {
        return dishDAO.getDishesID();
    }

    @Transactional
    public ResponseEntity<byte[]> photobyID(Long id){
        byte[] photo=null;


        photo= dishDAO.getDishPhoto(id);







        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<byte[]>(photo, headers, HttpStatus.OK);
    }


}