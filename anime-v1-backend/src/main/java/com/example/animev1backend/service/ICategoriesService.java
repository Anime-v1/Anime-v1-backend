package com.example.animev1backend.service;

import com.example.animev1backend.model.Categories;

import java.util.List;

public interface ICategoriesService {
    List<Categories> getAllCategories();
    Categories getCategoriesById(int id);
    Categories createCategories(Categories categories);
    Categories updateCategories(Long id,Categories categories);
    void deleteCategories(Long id);
}
