package com.calt.w1crud.coffeestore.Service;

import com.calt.w1crud.coffeestore.Controller.GlobalExceptionHandler;
import com.calt.w1crud.coffeestore.DTO.RequestCategory;
import com.calt.w1crud.coffeestore.Entity.Category;
import com.calt.w1crud.coffeestore.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void saveCategoryfromDTO(RequestCategory rCategory){
        categoryRepository.save(new Category(rCategory.getName(), rCategory.getDescription()));

    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Category getCategoryByID(Long id){
        Optional <Category> oCategory = categoryRepository.findById(id);
        if(!oCategory.isEmpty()){
            return oCategory.get();
        }
        return null;

    }
    public void deleteCategory(Long id){
       try{
           categoryRepository.delete(getCategoryByID(id));
       } catch (DataIntegrityViolationException e) {
           throw new DataIntegrityViolationException("Can't delete");
       }
    }


}
