package secure.entity;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by Тарас on 30.03.2017.
 */
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50)
    private String name;
    @Column(columnDefinition = "mediumblob")
    private Blob photo;

    @Column(length = 2000)
    private String ing;
    @Column
    private double price;

    Dish(){};
    Dish(String name,Blob photo,String ing,double price){
        this.name=name;
        this.photo= photo;
        this.ing=ing;
        this.price=price;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
