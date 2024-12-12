package fr.fms.dao;

import fr.fms.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    // Ex1.6 : Afficher les catégories triées par ordre croissant
    @Query("SELECT c FROM Category c ORDER BY c.name ASC")
    List<Category> findAllCategoriesOrderedByNameAsc();

    // Ex1.6 : Afficher les catégories triées par ordre décroissant
    @Query("SELECT c FROM Category c ORDER BY c.name DESC")
    List<Category> findAllCategoriesOrderedByNameDesc();
}
