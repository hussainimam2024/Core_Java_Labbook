package com.example.book_hive_project.service;

import com.example.book_hive_project.model.Order;
import com.example.book_hive_project.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    // Constructor injection of OrderRepository
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Place an Order - Customer places an order
    public Order placeOrder(Order order) {
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Customer cannot be null"); // Handle the error gracefully
        }
        order.setOrderDate(new Date()); // Set current date as order date
        order.setStatus("Pending"); // Initially set order status to "Pending"
        return orderRepository.save(order); // Save order to the database
    }

    // View Order Status - Customer can view their order status
    public Order getOrderStatus(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order with ID " + orderId + " not found"));
    }

    // Update Order Status - Admin can update order status
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order with ID " + orderId + " not found"));
        order.setStatus(status); // Set the new order status
        return orderRepository.save(order); // Save updated order
    }

    // Get Orders by Customer - Admin can view orders placed by a specific customer
    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    // Get All Orders - Admin can view all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Delete an Order - Admin can delete an order by ID
    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order with ID " + orderId + " not found");
        }
        orderRepository.deleteById(orderId);
    }
}
