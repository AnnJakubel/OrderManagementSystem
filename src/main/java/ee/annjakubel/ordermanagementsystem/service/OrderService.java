package ee.annjakubel.ordermanagementsystem.service;

import ee.annjakubel.ordermanagementsystem.model.Customer;
import ee.annjakubel.ordermanagementsystem.model.Order;
import ee.annjakubel.ordermanagementsystem.model.OrderLine;
import ee.annjakubel.ordermanagementsystem.model.Product;
import ee.annjakubel.ordermanagementsystem.repository.CustomerRepository;
import ee.annjakubel.ordermanagementsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//https://localhost:8080
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    public double calculateOrderSum(List<OrderLine> orders) {
        double sum = 0.0;
        for (OrderLine order : orders) {
            Product product = order.getProduct();
            int quantity = order.getQuantity();
            sum = sum + (product.getUnitPrice() * quantity);
        }
        return sum;
    }

    public Order saveToDatabase(Integer registrationCode) {
        Order order = new Order();
        Customer customer = customerRepository.getReferenceById(registrationCode);
        LocalDate today = LocalDate.now();
        order.setOrderLines(new ArrayList<OrderLine>());
        order.setCustomer(customer);
        order.setDate(today);
        return order;
    }

    public Order addOrderLineToOrder(OrderLine orderLine, Integer orderId) {
        Order orderFromDb = orderRepository.findById(orderId).get();
        List<OrderLine> orderLines = orderFromDb.getOrderLines();
        orderLines.add(orderLine);

        return orderFromDb;
    }
}
