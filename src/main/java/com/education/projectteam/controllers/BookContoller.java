package com.education.projectteam.controllers;
import com.education.projectteam.models.Book;
import com.education.projectteam.repo.BookRepository;
import com.education.projectteam.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class BookContoller {
    @Autowired
    private BookRepository productRepo;
    private BookService bookService;
    @GetMapping("/listProducts.html")
    public String showExampleView(@NotNull Model model)
    {
        List<Book> products = bookService.getAllBook();
        model.addAttribute("products", products);
        return "/listProducts.html";
    }
    @GetMapping("/")
    public String showAddProduct()
    {

        return "/addBook.html";
    }

    @PostMapping("/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
                              @RequestParam("pname") String name,
                              @RequestParam("desc") String desc)
    {
        bookService.saveBookToDB(file, name, desc);
        return "redirect:/listBook.html";
    }

    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {

        bookService.deleteBookById(id);
        return "redirect:/listBook.html";
    }

    @PostMapping("/changeName")
    public String changePname(@RequestParam("id") Long id,
                              @RequestParam("newPname") String name)
    {
        bookService.chageBookName(id, name);
        return "redirect:/listBook.html";
    }
    @PostMapping("/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
                                    @RequestParam("newDescription") String description)
    {
        bookService.changeBookDescription(id, description);
        return "redirect:/listBook.html";
    }

//    @PostMapping("/changePrice")
//    public String changePrice(@RequestParam("id") Long id ,
//                              @RequestParam("newPrice") int price)
//    {
//        bookService.changeBookPrice(id);
//        return "redirect:/listProducts.html";
//    }
}
