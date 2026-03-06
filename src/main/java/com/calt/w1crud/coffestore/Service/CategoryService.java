package com.calt.w1crud.coffestore.Service;

import com.calt.w1crud.coffestore.Entity.Category;
import com.calt.w1crud.coffestore.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    //no need to add autowire because there is only way to inject is through constructor with only one parameter
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
