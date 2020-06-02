package com.penchev.demo.service;

import com.penchev.demo.domain.entities.Category;
import com.penchev.demo.repository.CategoryRepository;
import com.penchev.demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final static String CATEGORIES_FILE_PATH = "C:\\Users\\vladislav.penchev\\Desktop\\Java\\DB_Hibernate_And_SpringData\\14.EXERCISE_SPRING_DATA_INTRO\\demo\\demo\\src\\main\\resources\\files\\categories.txt";

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if(this.categoryRepository.count() != 0){
            return;
        }

        String[] categoriesFileContent = this.fileUtil.getFileContent(CATEGORIES_FILE_PATH);

        for (String line : categoriesFileContent) {

            Category category = new Category();

            category.setName(line);

            this.categoryRepository.saveAndFlush(category);
        }


    }
}
