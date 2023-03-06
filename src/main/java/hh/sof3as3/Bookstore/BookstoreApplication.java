package hh.sof3as3.Bookstore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner examples(BookRepository bookRepository, CategoryRepository categoryRepository) {
		 
		return (args) -> {
			Category category1 = new Category("Fantasy");
			Category category2 = new Category("Children");
			Category category3 = new Category("Non-fiction");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			
			List<Category> categories = (List<Category>) categoryRepository.findAll();
			for (Category category : categories) {
				log.info(category.toString());
			}
			
			bookRepository.save(new Book("A.A. Milne", "Nalle Puh rakentaa talon", 1928, "1232323-22", 19.95, category2));
			bookRepository.save(new Book ("J.R.R. Tolkien", "The Lord of the Rings", 1954, "3232321-21", 29.95, category1));
			
			List<Book> books = (List<Book>) bookRepository.findAll();
			for (Book book : books) {
				log.info(book.toString());
			}
		};
	}

}
