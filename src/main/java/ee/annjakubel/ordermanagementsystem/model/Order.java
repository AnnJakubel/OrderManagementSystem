package ee.annjakubel.ordermanagementsystem.model;

import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private Customer customer;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private Date date;

}
