package com.coder.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.model.Category;
import com.coder.repository.CategoryRepository;
import com.coder.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category saveCategory(Category category) {
		Category saveCategory = categoryRepository.save(category);
		return saveCategory;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> allCategory = categoryRepository.findAll();
		return allCategory;
	}

	@Override
	public Category updateCategory(Category category) {
		Optional<Category> existingCategory = categoryRepository.findById(category.getId());
	    if (existingCategory.isPresent()) {
	        Category updatedCategory = existingCategory.get();
	        updatedCategory.setName(category.getName());
	        updatedCategory.setProducts(category.getProducts());
	        return categoryRepository.save(updatedCategory);
	    } else {
	        throw new RuntimeException("Category not found with id: " + category.getId());
	    }
	}

	@Override
	public Category getCategoryById(Integer id) {
		Optional<Category> findByCategory = categoryRepository.findById(id);
		if(findByCategory.isPresent()) {
			return findByCategory.get();
		}
		return null;
	}

	@Override
	public void deleteCategory(Integer id) {
		Optional<Category> findByCategoryDelete = categoryRepository.findById(id);
		if(findByCategoryDelete.isPresent()) {
			Category category = findByCategoryDelete.get();
			categoryRepository.delete(category);
		}
	}

}
