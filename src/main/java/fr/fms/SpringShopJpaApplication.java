package fr.fms;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringShopJpaApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringShopJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Exemple 1 : Récupérer un article par son ID et l'afficher
		System.out.println("=== Affichage d'un article spécifique ===");
		Long articleId = 1L; // ID de l'article à rechercher
		Article article = articleRepository.findById(articleId).orElse(null);
		if (article != null) {
			System.out.println(article);
		} else {
			System.out.println("Article non trouvé par son ID : " + articleId);
		}

		// Exemple 2 : Afficher tous les articles en base
		System.out.println("\n=== Affichage de tous les articles ===");
		for (Article a : articleRepository.findAll()) {
			System.out.println(a);
		}



		// Ex 1.1
//		Category smartphone = categoryRepository.save(new Category("Smartphone"));
//		Category tablet = categoryRepository.save(new Category("Tablet"));
//		Category pc = categoryRepository.save(new Category("Pc"));

//		articleRepository.save(new Article("Samsung", "s9", 250, 10));
//		articleRepository.save(new Article("Samsung", "s8", 200, 5));
//		articleRepository.save(new Article("Samsung", "GalaxyTab", 350, 15));



//		articleRepository.save(new Article("S10", "Samsung", 500, 20, smartphone));
//		articleRepository.save(new Article("S9", "Samsung", 350, 10, smartphone));
//		articleRepository.save(new Article("MI10", "Xiaomi", 100, 25, smartphone));
//
//		articleRepository.save(new Article("GalaxyTab", "Samsung", 450, 15, tablet));
//		articleRepository.save(new Article("Ipad", "Apple", 350, 12, tablet));
//
//		articleRepository.save(new Article("R510", "Asus", 600, 8, pc));

//		for (Article article : articleRepository.findByBrandAndPrice("Samsung", 200)) {
//			System.out.println(article);
//		}
		for (Article article1 : articleRepository.findByCategoryId(1L)) {
			System.out.println(article1);
		}
	}
}


