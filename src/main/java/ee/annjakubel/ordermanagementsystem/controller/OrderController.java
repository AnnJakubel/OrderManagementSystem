package ee.annjakubel.ordermanagementsystem.controller;

import ee.annjakubel.ordermanagementsystem.model.Customer;
import ee.annjakubel.ordermanagementsystem.model.Order;
import ee.annjakubel.ordermanagementsystem.model.OrderLine;
import ee.annjakubel.ordermanagementsystem.repository.CustomerRepository;
import ee.annjakubel.ordermanagementsystem.repository.OrderRepository;
import ee.annjakubel.ordermanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

//https://localhost:8080
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("order-management/order")
    public ResponseEntity<List<Order>> startOrder(@RequestParam Integer registrationCode) {
        Order order = orderService.saveToDatabase(registrationCode);
        orderRepository.save(order);
        return ResponseEntity.ok().body(orderRepository.findAll());
    }

    @GetMapping("order-management/order/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Integer orderId) {
        return ResponseEntity.ok()
                .body(orderRepository.findById(orderId).get());
    }

    @PutMapping("order-management/order/{orderId}")
    public ResponseEntity<Order> addOrderLine(@RequestBody OrderLine orderLine, @PathVariable Integer orderId) {
        Order updatedOrder = orderService.addOrderLineToOrder(orderLine, orderId);
        orderRepository.save(updatedOrder);
        return ResponseEntity.ok()
                .body(orderRepository.findById(orderId).get());
    }

    @GetMapping("order-management/order/date")
    public ResponseEntity<List<Order>> getOrderByDate(@RequestBody Date date) {
        return ResponseEntity.ok()
                .body(orderRepository.findOrderByDate(date));
    }

    @GetMapping("order-management/orders/customer")
    public ResponseEntity<List<Order>> getAllOrdersByCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok()
                .body(orderRepository.findAllByCustomer(customer));
    }

}
