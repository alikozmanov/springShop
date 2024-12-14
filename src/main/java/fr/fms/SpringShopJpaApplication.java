package fr.fms;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

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

		// Ex 1.1 :
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
//		for (Article article1 : articleRepository.findByCategoryId(1L)) {
//			System.out.println(article1);
//		}


//		// Ex 1.2 : Récupérer un article par son ID
//		System.out.println("=== Affichage d'un article spécifique ===");
//		Long articleId = 1L; // ID de l'article à rechercher
//		Article article = articleRepository.findById(articleId).orElse(null);
//		if (article != null) {
//			System.out.println(article);
//		} else {
//			System.out.println("Article non trouvé par son ID : " + articleId);
//		}
//
//		// Ex 1.2 : Afficher tous les articles en base
//		System.out.println("\n=== Affichage de tous les articles ===");
//		for (Article a : articleRepository.findAll()) {
//			System.out.println(a);
//		}
//
//		// Ex 1.3 : Recherche par description et marque
//		System.out.println("\n=== Recherche d'articles par description et marque ===");
//
//		String description = "S9";
//		String brand = "Samsung";
//
//		for (Article article1 : articleRepository.findByDescriptionContainsAndBrand(description, brand)) {
//			System.out.println(article1);
//		}

//		// Ex 1.4 : supprimer un article à partir de l’id
//		System.out.println("\n=== Supprimer un article  ===");
//		articleRepository.deleteArticleById(5L);


//		// Ex 1.5 :  update de l'article avec l'id
//		System.out.println("\n=== Mise à jour de l'article  ===");
//		articleRepository.updateArticleById(5L, "Samsung", "S24", 999);


//		// Ex 1.6 :  Ajouter des moyens pour afficher les noms des catégories classés par ordre croissant
//		System.out.println("\n=== Afficher par ordre croissant  ===");
//		for (Category category: categoryRepository.findAllCategoriesOrderedByNameAsc()) {
//			System.out.println(category);
//		}
//		// Ex 1.6 :  Ajouter des moyens pour afficher les noms des catégories classés par ordre décroissant
//		System.out.println("\n=== Afficher par ordre décroissant  ===");
//		for (Category category : categoryRepository.findAllCategoriesOrderedByNameDesc()) {
//			System.out.println(category);
//		}


//		// Ex 1.7 :  Ajouter une méthode de votre choix
//		System.out.println("\n=== Articles avec un prix supérieur à 300 ===");
//		double price = 300;
//		for (Article article1 : articleRepository.findArticlesByPriceGreater(price)) {
//			System.out.println(article1);
//		}

		// Ex TP :

		Scanner scan = new Scanner(System.in);

		while (true) { // Boucle pour afficher le menu en continu
			System.out.println("\n=== Menu ===");
			System.out.println("1 : Afficher tous les articles sans pagination ");
			System.out.println("2 : Afficher tous les articles avec pagination ");
			System.out.println("3: Ajouter un nouvel article");
			System.out.println("4: Afficher un article");
			System.out.println("0 : Sortie du programme ");
			System.out.println("Veuillez saisir une option : ");

			int choice = scan.nextInt(); // Lire les options

			switch(choice) {
				case 1:
					showAllArticles();
					break;
//				case 2:
//					showAllArticles2();
//					break;
				case 3:
					addNewArticle(scan);
					break;
				case 4:
					viewAnArticleId(scan);
					break;
				case 0:
					System.out.println("Au revoir");
					return;
				default:
					System.out.println("Option invalide, veuillez réeessayer");
			}
		}
	}

	// Afficher tous les articles
	private void showAllArticles() {
		System.out.println("\n=== Liste de tous les articles ===");
		for (Article article: articleRepository.findAll()) {
			System.out.println(article);
		}
	}

	// Ajouter un article
	private void addNewArticle(Scanner scan) {
		System.out.println("\n=== Ajouter un nouvel article ===");

		// Lire les détails de l'article
		System.out.print("Entrez la marque (brand) : ");
		String brand = scan.next();

		System.out.print("Entrez la description : ");
		String description = scan.next();

		System.out.print("Entrez le prix : ");
		double price = scan.nextDouble();

		System.out.print("Entrez la quantité : ");
		int quantity = scan.nextInt();

		System.out.print("Entrez l'ID de la catégorie : ");
		Long categoryId = scan.nextLong();

		// Vérifier si la catégorie existe
		Category category = categoryRepository.findById(categoryId).orElse(null);
		if (category == null) {
			System.out.println("Erreur : La catégorie avec l'ID " + categoryId + " n'existe pas.");
			return;
		}

		// Créer et sauvegarder l'article
		Article newArticle = new Article(description, brand, price, quantity, category);
		articleRepository.save(newArticle);

		System.out.println("Article ajouté avec succès !");
	}

	// Afficher un article par son id
	private void viewAnArticleId(Scanner scan) {
		System.out.println("\n=== Afficher un article par ID ===");

		System.out.print("Entrez l'ID de l'article : ");
		Long id = scan.nextLong();

		// Récupérer l'article en base
		Article article = articleRepository.findById(id).orElse(null);
		if (article != null) {
			System.out.println("Détails de l'article : " + article);
		} else {
			System.out.println("Aucun article trouvé avec l'ID : " + id);
		}

	}
}


