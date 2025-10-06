package com.poly.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.poly.lab4.model.Staff;
import jakarta.validation.Valid;

@Controller
public class StaffController {
    
    @GetMapping("/staff/create/form")
    public String createForm(Model model) {
        if (!model.containsAttribute("staff")) {
            model.addAttribute("staff", Staff.builder().build());
        }
        if (!model.containsAttribute("message")) {
            model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        }
        return "staff-create";
    }

    @PostMapping("/staff/create/save")
    public String createSave(
            Model model,
            @Valid @ModelAttribute("staff") Staff staff,
            BindingResult result,
            @RequestParam("photo_file") MultipartFile photoFile) {
        
        // Handle file upload
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
            // In a real application, you would save the file here
            // and handle any potential IO exceptions
        }
        
        if (result.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            // Save to database would go here
            model.addAttribute("message", "Thông tin đã được lưu thành công!");
        }
        
        return "staff-create";
    }
}