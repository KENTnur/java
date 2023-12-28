package com.education.projectteam.controllers;

import com.education.projectteam.models.Book;
import com.education.projectteam.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    private BookRepository productRepo;

    @RequestMapping(value = "/addProduct",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnAddProduct()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addProduct");
        //mv.addObject("var", "halim");
        return mv;

    }

    @RequestMapping(value = "/listBook",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnListProduct()
    {
        ModelAndView mv = new ModelAndView();
        List<Book> products = productRepo.findAll();
        mv.setViewName("listProducts");
        mv.addObject("products", products);
        return mv;
    }

    @GetMapping("/liblary")
    public String liblary(){
        return "Liblary";
    }
}
