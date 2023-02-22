package hh.sof3as3.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/categorylist")
	public String getCategories(Model model) {

		model.addAttribute("categories", categoryRepository.findAll());

		return "categorylist";
	}

	@GetMapping("/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";

	}

	@PostMapping("/savecategory")
	public String saveCategory(@ModelAttribute Category category) {
		categoryRepository.save(category);
		return "redirect:/categorylist";
	}

}