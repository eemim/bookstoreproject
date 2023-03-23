package hh.sof3as3.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;
import hh.sof3as3.Bookstore.domain.User;
import hh.sof3as3.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTests {

	@Autowired
	BookRepository bookRepo;
	@Autowired
	CategoryRepository catRepo;
	@Autowired
	UserRepository userRepo;
	
	// Testataan löytääkö Kirjan nimen perusteella
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bookRepo.findByTitle("The Lord of the Rings");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("J.R.R. Tolkien");
	}
	
	// Löytääkö Käyttäjän käyttäjänimen perusteella
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = userRepo.findByUsername("user");
		
		assertThat(user.getId()).isNotNull();
		assertThat(user.getRole()).isEqualTo("USER");
	}
	
	// Löytääkö Kategorian nimen perusteella
	@Test
	public void findByCategoryNameShouldReturnCategory() {
		List<Category> categories = catRepo.findByName("Fantasy");

		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryid()).isNotNull();
	}
	
	// Kirjan luonti
	@Test
	public void createNewBook() {
		Book book = new Book("Eemi Mäntylä", "Testauksen iloa", 2023, "111-222", 9.95,
				catRepo.findByName("Fantasy").get(0));
		bookRepo.save(book);

		assertThat(book.getId()).isNotNull();
	}

	// Kirjan poisto
	@Test
	public void deleteBook() {
		bookRepo.delete(bookRepo.findByTitle("The Lord of the Rings").get(0));
		List<Book> books = bookRepo.findByTitle("The Lord of the Rings");
		
		assertThat(books).hasSize(0);
	}

}
