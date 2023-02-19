package ee.annjakubel.ordermanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "sku_code_generator")
    @SequenceGenerator(name="sku_code_generator", sequenceName = "product_seq",
            initialValue = 63124210,
            allocationSize=1)
    private Integer skuCode;
    private String name;
    private double unitPrice;
}
