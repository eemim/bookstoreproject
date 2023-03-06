package hh.sof3as3.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/categorylist")
	public String getCategories(Model model) {

		model.addAttribute("categories", categoryRepository.findAll());

		return "categorylist";
	}
	
	//REST allCategories
	@GetMapping(value="/categories")
	public @ResponseBody List<Category> getCategories(){
		return(List<Category>) categoryRepository.findAll();
	}
	
	//Rest categoryById
	@GetMapping(value="/categories/{id}")
	public @ResponseBody Optional<Category> getOneCategory(@PathVariable("id") Long categoryid){
		return categoryRepository.findById(categoryid);
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
