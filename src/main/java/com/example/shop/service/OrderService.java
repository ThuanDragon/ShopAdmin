package com.example.shop.service;

import com.example.shop.entity.CustomerOrder;
import com.example.shop.entity.Product;
import com.example.shop.repository.CustomerOrderRepository;
import com.example.shop.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    private final CustomerOrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(CustomerOrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public List<CustomerOrder> findAllNewest() {
        return orderRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public CustomerOrder createOrder(Long productId, String customerName, String phone, String address, Integer orderQuantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Sản phẩm không tồn tại"));

        if (orderQuantity == null || orderQuantity <= 0) {
            throw new IllegalArgumentException("Số lượng đặt phải lớn hơn 0");
        }
        if (product.getQuantity() < orderQuantity) {
            throw new IllegalArgumentException("Không đủ hàng trong kho");
        }

        product.setQuantity(product.getQuantity() - orderQuantity);
        productRepository.save(product);

        CustomerOrder order = new CustomerOrder();
        order.setProduct(product);
        order.setCustomerName(customerName);
        order.setPhone(phone);
        order.setAddress(address);
        order.setQuantity(orderQuantity);
        order.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(orderQuantity)));
        return orderRepository.save(order);
    }
}
