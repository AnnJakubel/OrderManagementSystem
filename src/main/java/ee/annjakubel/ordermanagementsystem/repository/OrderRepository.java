package ee.annjakubel.ordermanagementsystem.repository;

import ee.annjakubel.ordermanagementsystem.model.Customer;
import ee.annjakubel.ordermanagementsystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer>{

    List<Order> findOrderByDate(Date date);
    List<Order> findAllByCustomer(Customer customer);
}
