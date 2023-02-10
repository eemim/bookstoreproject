package hh.sof3as3.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/booklist")
	public String getBooks(Model model) {

		model.addAttribute("books", bookRepository.findAll());

		return "booklist";
	}

	@GetMapping("/addbook")
	public String addStudent(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";

	}

	@PostMapping("/savebook")
	public String saveBook(@ModelAttribute Book book, Model model) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String bookEditing(@PathVariable("id")Long id, Model model) {
		model.addAttribute("book", bookRepository.findById(id));
		return "editbook";
	}

}
