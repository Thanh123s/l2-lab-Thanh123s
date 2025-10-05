package com.example.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class ProductController {
    // Danh sách để lưu trữ tất cả sản phẩm
    private List<Product> productList = new ArrayList<>(Arrays.asList(
        new Product("A", 1.0),
        new Product("B", 12.0)
    ));

    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        /*?1*/
        model.addAttribute("p", p);
        return "product/form";
    }
    
    @PostMapping("/product/save")
    public String save(/*?2*/ @RequestParam String name, 
                     @RequestParam double price, 
                     Model model) {
        // Giữ nguyên sản phẩm gốc trong model
        Product original = new Product("iPhone 30", 5000.0);
        model.addAttribute("p", original);
        
        // Tạo và thêm sản phẩm mới vào model với tên p2
        Product submitted = new Product(name, price);
        model.addAttribute("p2", submitted);
        
        // Thêm sản phẩm mới vào danh sách
        productList.add(submitted);
        
        // Cập nhật lại danh sách sản phẩm trong model
        model.addAttribute("items", new ArrayList<>(productList));
        
        return "product/form";
    }
    
    /*?3*/
    @ModelAttribute("items")
    public List<Product> getItems() {
        // Trả về một bản sao của danh sách để tránh thay đổi không mong muốn
        return new ArrayList<>(productList);
    }
}

