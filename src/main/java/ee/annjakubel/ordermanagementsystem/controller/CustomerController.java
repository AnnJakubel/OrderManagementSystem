package ee.annjakubel.ordermanagementsystem.controller;

import ee.annjakubel.ordermanagementsystem.model.Customer;
import ee.annjakubel.ordermanagementsystem.repository.CustomerRepository;
import ee.annjakubel.ordermanagementsystem.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @PostMapping("order-management/customer")
    public ResponseEntity<List<Customer>> addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return ResponseEntity.ok().body(customerRepository.findAll());
    }
}
