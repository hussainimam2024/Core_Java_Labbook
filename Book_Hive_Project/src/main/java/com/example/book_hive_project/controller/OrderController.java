package com.example.book_hive_project.controller;

import com.example.book_hive_project.model.Order;
import com.example.book_hive_project.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Place an Order
    @PostMapping("create")
    public Order placeOrder(@RequestBody Order order) {
        if (order.getCustomer() == null) {
            throw new RuntimeException("Customer cannot be null"); // Handle the error
        }
        return orderService.placeOrder(order);
    }

    @GetMapping("/csrf-token") // Updated URL for CSRF token
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        // Retrieve the CSRF token from the request attributes
        return (CsrfToken) request.getAttribute("_csrf");
    }
    // View Order Status
    @GetMapping("/{orderId}")
    public Order getOrderStatus(@PathVariable Long orderId) {
        return orderService.getOrderStatus(orderId);
    }

    // Update Order Status
    @PutMapping("/{orderId}/status")
    public Order updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return orderService.updateOrderStatus(orderId, status);
    }

    // Get Orders by Customer
    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }
}
