package com.fortunate.crudexamplewithspringboot.controller;

import com.fortunate.crudexamplewithspringboot.model.Product;
import com.fortunate.crudexamplewithspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String viewHomaPage(Model model) {
        List<Product> listProducts = service.listAllProduct();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "newProduct";
    }

    //@RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showNewProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("editProduct");
        //mav.setViewName("editProduct"); VIEW NAME IS PASSED DIRECTLY ABOVE
        mav.addObject("product", service.get(id));
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.deleteProductById(id);
        return "redirect:/";
    }
}
