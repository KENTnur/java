package com.education.projectteam.service;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import com.education.projectteam.models.Book;
import com.education.projectteam.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void  saveBookToDB(MultipartFile file,String name,String description
            )
    {
        Book p = new Book();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setDescription(description);

        p.setName(name);
//        p.setViews(views);

        bookRepository.save(p);
    }
    public List<Book> getAllBook()
    {
        return bookRepository.findAll();
    }
    public void deleteBookById(Long id)
    {
        bookRepository.deleteById(id);
    }
    public void chageBookName(Long id ,String name)
    {
        Book p = new Book();
        p = bookRepository.findById(id).get();
        p.setName(name);
        bookRepository.save(p);
    }
    public void changeBookDescription(Long id , String description)
    {
        Book p = new Book();
        p = bookRepository.findById(id).get();
        p.setDescription(description);
        bookRepository.save(p);
    }
    public void changeBookPrice(Long id)
    {
        Book p = new Book();
        p = bookRepository.findById(id).get();
//        p.setViews(views);
        bookRepository.save(p);
    }
}

