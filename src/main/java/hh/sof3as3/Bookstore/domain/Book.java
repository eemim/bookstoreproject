package hh.sof3as3.Bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String author;
	private String title;
	@Column(name = "publishing_year")
	private int year;
	private String isbn;
	private double price;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public Book() {
	}

//	public Book() {
//		super();
//		this.id = null;
//		this.author = null;
//		this.title = null;
//		this.year = 0;
//		this.isbn = null;
//		this.price = 0;
//	}

	public Book(String author, String title, int year, String isbn, double price, Category category) {
		super();
		this.author = author;
		this.title = title;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

//	public Book(Long id, String author, String title, int year, String isbn, double price) {
//		super();
//		this.id = id;
//		this.author = author;
//		this.title = title;
//		this.year = year;
//		this.isbn = isbn;
//		this.price = price;
//	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		if (this.category != null) {
			return "Book [id=" + id + ", author=" + author + ", title=" + title + ", year=" + year + ", isbn=" + isbn
					+ ", price=" + price + ", category=" + this.getCategory() + "]";
		} else {
			return "\"Book [id=" + id + ", author=" + author + ", title=" + title + ", year=" + year + ", isbn=" + isbn
					+ "price=" + price;
		}
	}

}
