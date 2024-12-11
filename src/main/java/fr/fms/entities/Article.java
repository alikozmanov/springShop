package fr.fms.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String description;
    private double price;
    private int quantity; // Utilisez un int pour quantité

    @ManyToOne
    private Category category;


    public Article(String description,String brand, double price, int quantity, Category category) {
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }


    public Article(String description, String brand, double price, int quantity) {
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Article() {
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
}
