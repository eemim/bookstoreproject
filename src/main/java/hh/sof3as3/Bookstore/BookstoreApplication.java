package hh.sof3as3.Bookstore;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner examples(BookRepository bookRepository) {
		 
		return (args) -> {
			Book book1 = new Book("A.A. Milne", "Nalle Puh rakentaa talon", 1928, "1232323-22", 19.95);
			Book book2 = new Book ("J.R.R. Tolkien", "The Lord of the Rings", 1954, "3232321-21", 29.95);
			bookRepository.save(book1);
			bookRepository.save(book2);
			
			List<Book> books = (List<Book>) bookRepository.findAll();
			for (Book book : books) {
				System.out.println(book.toString());
			}
		};
	}

}
