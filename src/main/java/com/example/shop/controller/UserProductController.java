package com.example.shop.controller;

import com.example.shop.service.OrderService;
import com.example.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class UserProductController {
    private final ProductService productService;
    private final OrderService orderService;

    public UserProductController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "user/products";
    }

    @PostMapping("/{id}/order")
    public String order(@PathVariable Long id,
                        @RequestParam String customerName,
                        @RequestParam String phone,
                        @RequestParam String address,
                        @RequestParam Integer quantity,
                        RedirectAttributes ra) {
        try {
            orderService.createOrder(id, customerName, phone, address, quantity);
            ra.addFlashAttribute("message", "Đặt hàng thành công! Admin sẽ xử lý đơn của bạn.");
        } catch (IllegalArgumentException ex) {
            ra.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/products";
    }
}
