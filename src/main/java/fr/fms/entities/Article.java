package fr.fms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String brand;
    private String description;
    private double price;

    public Article() {
    }

    public Article(Long id, String brand, String description, double price) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // Méthode toString pour afficher les informations de l'article sous forme de chaîne
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}