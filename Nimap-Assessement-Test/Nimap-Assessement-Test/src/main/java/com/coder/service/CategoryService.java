package com.coder.service;

import java.util.List;

import com.coder.model.Category;

public interface CategoryService {

	public Category saveCategory(Category category);
	public List<Category> getAllCategory();
	public Category updateCategory(Category category);
	public Category getCategoryById(Integer id);
	public void deleteCategory(Integer id);
}
