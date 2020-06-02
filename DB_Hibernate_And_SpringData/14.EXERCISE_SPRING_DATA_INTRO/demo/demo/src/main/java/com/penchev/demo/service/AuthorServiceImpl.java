package com.penchev.demo.service;

import com.penchev.demo.domain.entities.Author;
import com.penchev.demo.repository.AuthorRepository;
import com.penchev.demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final static String AUTHORS_FILE_PATH = "C:\\Users\\vladislav.penchev\\Desktop\\Java\\DB_Hibernate_And_SpringData\\14.EXERCISE_SPRING_DATA_INTRO\\demo\\demo\\src\\main\\resources\\files\\authors.txt";

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if(this.authorRepository.count() != 0){
            return;
        }

        String[] authorFileContent = this.fileUtil.getFileContent(AUTHORS_FILE_PATH);

        for (String line : authorFileContent) {
            String[] names = line.split("\\s+");

            Author author = new Author();
            author.setFirstName(names[0]);
            author.setLastName(names[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }

}
