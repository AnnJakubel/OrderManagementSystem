package ee.annjakubel.ordermanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "order_generator")
    @SequenceGenerator(name="order_generator", sequenceName = "order_seq",
            initialValue = 12321,
            allocationSize=1)
    private Integer orderId;
    @ManyToMany
    private List<OrderLine> orderLines;
    @OneToOne
    private Customer customer;
    @Column(name = "date")
    private LocalDate date;

}
