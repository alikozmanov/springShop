package fr.fms.dao;

import fr.fms.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {
//    public List<Article> findByBrand(String brand);
//    public List<Article> findByBrandContains(String brand);
//    public List<Article> findByBrandAndPrice(String brand, double price);
//    public List<Article> findByCategoryId( Long categoryId);
//    // Ex 1.3 Recherche par description et marque
//    public List<Article> findByDescriptionContainsAndBrand(String description, String brand);
//    // Ex 1.4 supprimer un article à partir de l’id
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Article a WHERE a.id = :id")
//    void deleteArticleById(@Param("id") Long id);
//
//    // Ex 1.5 : update de l'article avec l'id
//    @Modifying
//    @Transactional
//    @Query("UPDATE Article a SET a.brand = :brand, a.description = :description, a.price = :price WHERE a.id = :id")
//    public void updateArticleById(@Param("id") Long id, @Param("brand") String brand, @Param("description") String description, @Param("price") double price);
//
//    // Ex 1.7 : Ajouter une méthode de votre choix
//    @Query("SELECT a FROM Article a WHERE a.price > :price")
//    List<Article> findArticlesByPriceGreater(double price);

}
