package com.example.animev1backend.service.implement;

import com.example.animev1backend.model.Categories;
import com.example.animev1backend.repository.ICategoriesRepository;
import com.example.animev1backend.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServerImplement implements ICategoriesService {
    @Autowired
    private ICategoriesRepository categoriesRepository;
    @Override
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories getCategoriesById(int id) {
        Optional<Categories> optional = categoriesRepository.findById((long) id);
        return optional.orElse(null); // Hoặc throw exception nếu cần xử lý lỗi
    }

    @Override
    public Categories createCategories(Categories categories) {
        return categoriesRepository.save(categories);
    }

    @Override
    public Categories updateCategories(Long id, Categories categories) {
        Optional<Categories> optional = categoriesRepository.findById(id);
        if (optional.isPresent()) {
            Categories existing = optional.get();
            existing.setName(categories.getName());
            return categoriesRepository.save(existing);
        }
        return null; // Hoặc throw exception nếu không tìm thấy
    }

    @Override
    public void deleteCategories(Long id) {
        categoriesRepository.deleteById(id);
    }
}
