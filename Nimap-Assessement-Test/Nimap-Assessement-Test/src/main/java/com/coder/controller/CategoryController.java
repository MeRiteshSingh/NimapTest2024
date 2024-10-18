package com.coder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.model.Category;
import com.coder.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategories(){
		 List<Category> allCategory = categoryService.getAllCategory();
		 return new ResponseEntity<>(allCategory,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id){
		
		Category categoryById = categoryService.getCategoryById(id);
		if (ObjectUtils.isEmpty(categoryById)) {	
			return new ResponseEntity<>("Category Not found",HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return new ResponseEntity<>(categoryById,HttpStatus.OK);
		
	}
	@PostMapping("/save")
	public ResponseEntity<?> saveCategory(@RequestBody Category category){
		Category saveCategory = categoryService.saveCategory(category);
		if(ObjectUtils.isEmpty(saveCategory)) {
			return new ResponseEntity<>("Category Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveCategory,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody Category category){
		
		Category getCategory = categoryService.getCategoryById(id);
		if (ObjectUtils.isEmpty(getCategory)) {	
			return new ResponseEntity<>("Category Not found",HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return ResponseEntity.ok(categoryService.updateCategory(category));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
		categoryService.deleteCategory(id);
		return new ResponseEntity<>("Delete Successfully",HttpStatus.OK);
	}
}
