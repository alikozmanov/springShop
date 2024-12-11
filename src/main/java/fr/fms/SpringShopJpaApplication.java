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
		//categoryRepository.save(new Category("Smartphone"));
		//articleRepository.save((new Article("Samsung","s9",250)));
		//articleRepository.save((new Article("Samsung","s8",250)));
		//articleRepository.save((new Article("Samsung","GalaxyTab",350)));
		for(Article article : articleRepository.findByBrandAndPrice("Samsung",250)) {
			System.out.println(article);
		}
	}
}
