package com.practice.ssm.controller;

import com.practice.ssm.daomain.Product;
import com.practice.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll();
        System.out.println(productList);
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {

        System.out.println(product);
        productService.save(product);
        return "redirect:findAll.do";
    }

}
