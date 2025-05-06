package com.example.animev1backend.repository;

import com.example.animev1backend.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriesRepository extends JpaRepository<Categories, Long> {

}
