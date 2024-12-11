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
		categoryRepository.save(new Category("Smartphone"));

		articleRepository.save(new Article("Samsung", "s9", 250, 10));
		articleRepository.save(new Article("Samsung", "s8", 200, 5));
		articleRepository.save(new Article("Samsung", "GalaxyTab", 350, 15));

		Category smartphone = categoryRepository.save(new Category("Smartphone"));
		Category tablet = categoryRepository.save(new Category("Tablet"));
		Category pc = categoryRepository.save(new Category("Pc"));

		articleRepository.save(new Article("S10", "Samsung", 500, 20, smartphone));
		articleRepository.save(new Article("S9", "Samsung", 350, 10, smartphone));
		articleRepository.save(new Article("MI10", "Xiaomi", 100, 25, smartphone));

		articleRepository.save(new Article("GalaxyTab", "Samsung", 450, 15, smartphone));
		articleRepository.save(new Article("Ipad", "Apple", 350, 12, smartphone));

		articleRepository.save(new Article("R510", "Asus", 600, 8, smartphone));

		for (Article article : articleRepository.findByBrandAndPrice("Samsung", 200)) {
			System.out.println(article);
		}
	}

}
