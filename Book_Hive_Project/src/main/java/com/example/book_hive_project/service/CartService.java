package com.example.book_hive_project.service;

import com.example.book_hive_project.model.Cart;
import com.example.book_hive_project.repository.CartRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getCustomerCart(Long customerId) {
        // Ensure that the current logged-in user has access to this cart (only their own cart)
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedInEmail = user.getUsername();

        // Assuming the customerId is linked to the user via email, modify this logic if needed
        if (isValidUserForCart(loggedInEmail, customerId)) {
            return cartRepository.findByCustomerId(customerId);
        } else {
            throw new SecurityException("Access Denied: You do not have permission to access this cart.");
        }
    }

    public Cart addToCart(Cart cart) {
        // Ensure the user is adding to their own cart
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedInEmail = user.getUsername();

        // Verify the customerId matches the logged-in user's email, if needed
        if (isValidUserForCart(loggedInEmail, cart.getCustomer().getId())) {  // Use getCustomer().getId()
            return cartRepository.save(cart);
        } else {
            throw new SecurityException("Access Denied: You do not have permission to add items to this cart.");
        }
    }

    public void removeFromCart(Long cartId) {
        // Verify ownership before removing the item
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedInEmail = user.getUsername();

        if (isValidUserForCart(loggedInEmail, cart.getCustomer().getId())) {  // Use getCustomer().getId()
            cartRepository.deleteById(cartId);
        } else {
            throw new SecurityException("Access Denied: You do not have permission to remove items from this cart.");
        }
    }

    // Utility method to check if the current user is allowed to access the given cart
    private boolean isValidUserForCart(String loggedInEmail, Long customerId) {
        // Modify the logic to match your application's requirements. For example:
        // Check if the customerId corresponds to the logged-in user's email (assuming email is unique).
        // If the user’s email is associated with the customerId in your system, return true.
        return true; // For now, assuming the email and customerId match (you should implement proper logic).
    }
}
