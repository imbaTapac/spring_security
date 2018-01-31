package secure.DAO;

import org.springframework.stereotype.Repository;
import secure.entity.Dish;
import secure.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DishDAOImpl implements DishDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addDish(Dish dish) {
        entityManager.merge(dish);
    }

    @Override
    public void deleteDish(long[] ids) {

    }

    @Override
    public void updateDish(long id) {

    }

    @Override
    public byte[] getDishPhoto(Long id) {
        Query query;
        query = entityManager.createQuery("SELECT d.photo FROM Dish d Where d.id=:id",Blob.class );
        query.setParameter("id", id);
        List <Blob> blobs=query.getResultList();
        Blob blob = blobs.get(0);
        byte[] blobAsBytes=null;
        try {
            int blobLength = (int) blob.length();
            blobAsBytes= blob.getBytes(1, blobLength);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                blob.free();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        return  blobAsBytes;
    }

    @Override
    public List<String[]> getDishName(long id) {
        return null;
    }

    @Override
    public List<String[]> getDishIng(long id) {
        return null;
    }

    @Override
    public List<String[]> getDishPrice(long id) {
        return null;
    }
    @Override
    public List <Dish> getDishesID(){
        Query query;
        //dish.class
        query = entityManager.createQuery("SELECT d FROM Dish d ",Dish.class);
        List<Dish> id= query.getResultList();




        return id;
    }
}